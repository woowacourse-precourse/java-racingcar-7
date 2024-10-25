package racingcar;


import racingcar.controller.Controller;
import racingcar.model.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.RoundNumberValidator;
import racingcar.util.CarNameValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        List<String> carNames = CarNameValidator.getSplitCarName(InputView.readCarNames());
        int numberOfRounds = RoundNumberValidator.parseToInt();

        CarStatus carStatus = new CarStatus(carNames);
        Controller controller = new Controller(carStatus, outputView);

        controller.playGame(numberOfRounds);
    }
}