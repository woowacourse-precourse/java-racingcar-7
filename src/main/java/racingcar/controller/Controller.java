package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.Utils;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private List<Car> cars;
    private final Validator validator;
    private final Utils utils;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(Validator validator, Utils utils, InputView inputView, OutputView outputView) {
        this.validator = validator;
        this.utils = utils;
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = new ArrayList<>();
    }

    private void inputAndValidateCars() {
        String s = inputView.inputCarNames();

        validator.validateInputNotBlank(s);
        validator.validateNoEmptyCarNames(s);

        String[] carNames = utils.convertToCarNameArray(s);

        validator.validateCarNameLength(carNames);
        utils.saveCarNamesToList(carNames, cars);
    }
}
