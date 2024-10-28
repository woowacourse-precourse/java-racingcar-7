package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RaceProgressService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RaceProgressService raceProgressService = new RaceProgressService();
        RacingGameService racingGameService = new RacingGameService(raceProgressService);
        RacingGameController controller = new RacingGameController(inputView, outputView, racingGameService);

        controller.run();
    }
}
