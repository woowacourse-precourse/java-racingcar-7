package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class CarRacingGameService {

    public void startRacing(CarNameRequest carNameRequest, TryNumberRequest tryNumberRequest) {
        List<Car> carList = createCarList(carNameRequest);

        OutputView.printRacingResultMessage();
        playRounds(carList, tryNumberRequest.tryNumber());
        printWinners(carList);

    }

    private List<Car> createCarList(CarNameRequest carNameRequest) {
        return carNameRequest.carNameList().stream()
                .map(Car::of)
                .toList();
    }

    private void playRounds(List<Car> carList, int round) {
        for(int i=0; i<round; i++) {
            carList.forEach(Car::move);
            OutputView.printRacingResult(carList);
        }
    }

    private void printWinners(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);
        String winner = findWinners(carList, maxPosition);

        OutputView.printResultWinner(winner);
    }

    private int findMaxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private String findWinners(List<Car> carList, int maxPosition) {
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

}
