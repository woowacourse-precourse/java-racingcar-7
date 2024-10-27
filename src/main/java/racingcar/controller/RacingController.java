package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.Utils;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final List<Car> cars = new ArrayList<>();
    private int tryNumber;

    // 컨트롤러 실행
    public void run() {
        inputInfo();
        startRace();
        endRace();
    }

    // 입력 기능
    private void inputInfo() {
        String input = InputView.inputCarNames(); // 자동차 이름 입력
        List<String> carArr = Utils.splitDelimiterCars(input); // 쉼표 기준으로 자동차 이름 나누기

        for (String name : carArr) {
            InputValidator.validateNameLength(name);
            cars.add(new Car(name));
        }

        tryNumber = InputView.inputTryNumber(); // 시도 횟수 입력
    }

    // 경주 시작
    private void startRace() {
        while (tryNumber > 0) {
            advanceMoveCar();
            runResult(cars);
            tryNumber--;
        }
    }

    // 차량 전진
    private void advanceMoveCar() {
        for (Car car : cars) {
            moveCarAllowed(car);
        }
    }

    // 전진 조건 만족하는 지 검사
    private void moveCarAllowed(Car car) {
        if (Utils.advanceConditions()) {
            car.move();
        }
    }

    private void runResult(List<Car> cars) {
        OutputView.printRunResult(cars);
    }

    private void endRace() {
        List<String> winners = new ArrayList<>();
        int max = -1;
        for (Car car : cars) {
            if (car.getMove() > max) {
                max = car.getMove();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getMove() == max) {
                winners.add(car.getName());
            }
        }
        OutputView.printWinner(winners);
    }
}