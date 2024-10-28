package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.RaceProgressService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RaceProgressService raceProgressService = new RaceProgressService(randomNumberGenerator);
        RacingGameService racingGameService = new RacingGameService(raceProgressService);
        RacingGameController controller = new RacingGameController(inputView, outputView, racingGameService);

        controller.run();
    }
}
