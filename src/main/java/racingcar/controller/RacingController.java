package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class RacingController {

    private InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void startRacing() {
        List<Car> cars = prepareRacingCar();
        int roundCount = prepareRoundCount();

        processRacing(cars, roundCount);
        List<Car> winners = determineWinner(cars);
    }

    private List<Car> prepareRacingCar() {
        String rawCarNames = inputView.inputCarNames();
        List<String> carNames = List.of(rawCarNames.split(","));
        return carNames.stream().map(Car::new).toList();
    }

    private int prepareRoundCount() {
        String rawRoundCount = inputView.inputRoundCount();
        return Integer.parseInt(rawRoundCount);
    }

    private void processRacing(List<Car> cars, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            cars.forEach(Car::attemptMove);
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
}
