package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameController {

    /**
     * 자동차 이름들을 Car 객체 리스트로 변환
     */
    public List<Car> convertCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    /**
     * 자동차별로 게임을 1회 실행
     */
    public void startOneGame(List<Car> cars) {
        for (Car car : cars) {
            car.startOneGame();
        }
    }

    public void printGameResult(List<Car> cars) {
        OutputView.printGameResult(cars);
    }
}
