package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.ThreadLocalRandomNumberGenerator;
import racingcar.view.RacingView;

public class Application {
    public static void main(String[] args) {
        RacingView racingView = new RacingView();
        RandomNumberGenerator randomNumberGenerator = new ThreadLocalRandomNumberGenerator();

        RacingCarController racingCarController = new RacingCarController(racingView, randomNumberGenerator);
        racingCarController.run();

        racingView.viewClose();
    }
}
