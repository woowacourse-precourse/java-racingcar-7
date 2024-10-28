package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new OutputView(),
                new InputView()
        );
        gameController.run();

        Console.close();
    }

}
