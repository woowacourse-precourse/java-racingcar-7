package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RaceController raceController = new RaceController(
                new InputView(),
                new OutputView()
        );

        raceController.run();
        Console.close();
    }
}
