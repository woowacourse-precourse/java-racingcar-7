package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(
                new InputView(),
                new OutputView(),
                new RaceService()
        );
        raceController.race();
        raceController.selectWinner();
    }
}
