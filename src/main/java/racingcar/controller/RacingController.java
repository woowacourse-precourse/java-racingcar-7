package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.InputDecodeService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private InputView inputView;
    private OutputView outputView;
    private InputDecodeService inputDecodeService;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputDecodeService = new InputDecodeService();
    }

    public void startRacing() {
        List<Car> cars = prepareRacingCar();
        int roundCount = prepareRoundCount();

        processRacing(cars, roundCount);
        List<Car> winners = determineWinner(cars);

        printWinners(winners);
    }

    private List<Car> prepareRacingCar() {
        String rawCarNames = inputView.inputCarNames();
        return inputDecodeService.decodeRawCarNames(rawCarNames);
    }

    private int prepareRoundCount() {
        String rawRoundCount = inputView.inputRoundCount();
        return inputDecodeService.decodeRawRoundCount(rawRoundCount);
    }

    private void processRacing(List<Car> cars, int roundCount) {
        outputView.outputRacingProcessingStart();
        for (int i = 0; i < roundCount; i++) {
            cars.forEach(Car::attemptMove);
            outputView.outputCarDetails(cars);
        }
    }

    private List<Car> determineWinner(List<Car> cars) {
        int maxMovedDistance = cars.stream()
                .map(Car::getMovedDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차 중 가장 많이 이동한 거리를 구할 수 없습니다."));
        return cars.stream()
                .filter(car -> car.isWinner(maxMovedDistance))
                .toList();
    }

    private void printWinners(List<Car> winners) {
        outputView.outputWinners(winners);
    }
}
