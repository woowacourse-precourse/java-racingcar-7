package racingcar.controller;

import java.util.List;
import racingcar.utils.Constants;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final Validator validator;
    private final InputView inputView;
    private final OutputView outputView;

    public CarController() {
        validator = new Validator();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void addCars() {
        String inputNames = inputView.getInputNames();
        List<String> names = List.of(inputNames.split(Constants.COMMA));
        for (String name : names) {
            validator.validateName(name);
        }
    }
}
