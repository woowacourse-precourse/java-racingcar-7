package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;
import racingcar.model.Car;
import racingcar.util.Util;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();

    public void run() {
        List<Car> cars = readyCar();
        Long times = readyTimes();
        showGameResult(playGame(cars, times));
    }

    private List<Car> readyCar() {
        outputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String string = inputView.input();
        validator.validateNames(string);
        List<Car> cars = new ArrayList<>();
        for (String name : Util.splitByComma(string)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private Long readyTimes() {
        outputView.print("시도할 횟수는 몇 회인가요?");
        final Long times = inputView.longInput();
        validator.validateTimes(times);
        outputView.print("");
        return times;
    }

    private List<Car> playGame(List<Car> cars, Long times) {
        LongStream.range(0L, times)
                .forEach(n -> playSet(cars));
        return cars;
    }

    private void playSet(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.forward();
            }
        }
    }
}
