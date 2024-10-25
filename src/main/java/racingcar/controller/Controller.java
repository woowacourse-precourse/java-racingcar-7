package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.Utils;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private List<Car> racingCarList;
    private final Validator validator;
    private final Utils utils;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(Validator validator, Utils utils, InputView inputView, OutputView outputView) {
        this.validator = validator;
        this.utils = utils;
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
