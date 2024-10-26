package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class CarRacingGameService {

    public void startRacing(CarNameRequest carNameRequest, TryNumberRequest tryNumberRequest) {
        int round = tryNumberRequest.tryNumber();
        List<Car> carList = carNameRequest.carNameList().stream()
                .map(Car::of)
                .toList();

        OutputView.printRacingResultMessage();
        playRound(carList, round);
        printWinner(carList);

    }

    private void playRound(List<Car> carList, int round) {
        for(int i=0; i<round; i++) {
            carList.forEach(Car::move);
            OutputView.printRacingResult(carList);
        }
    }

    private void printWinner(List<Car> carList) {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        String winner = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));

        OutputView.printResultWinner(winner);
    }

}
