package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Race;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Race race = new Race(randomNumberGenerator);

        RacingCarController controller = new RacingCarController(inputView, outputView, race);
        controller.run();
    }
}