package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.CarNameValidator;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarNameValidator carNameValidator = new CarNameValidator();

        GameController gameController = new GameController(inputView, outputView, carNameValidator);
        gameController.run();
    }

}
