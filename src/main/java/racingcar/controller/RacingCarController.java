package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.parser.InputParser;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView();
    }

    public void play() {
        List<Car> cars = initializeCars();
    }

    private List<Car> initializeCars() {
        String carNames = inputView.getCarNamesInput();
        CarNameValidator.validate(carNames);
        return InputParser.parseCars(carNames);
    }
}
