package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
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
        outputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = readyCar();
        outputView.print("시도할 횟수는 몇 회인가요?");
        final Long times = inputView.longInput();
        outputView.print("");
    }

    private List<Car> readyCar() {
        String string = inputView.input();
        validator.validateNames(string);
        List<Car> cars = new ArrayList<>();
        for (String name : Util.splitByComma(string)) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
