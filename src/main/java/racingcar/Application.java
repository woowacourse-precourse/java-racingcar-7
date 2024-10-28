package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Movement;
import racingcar.domain.NumberGenerator;
import racingcar.domain.NumberOverFour;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public final static int RANDOM_NUMBER_END_INCLUSIVE = 9;

    public static void main(String[] args) {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator(RANDOM_NUMBER_END_INCLUSIVE);
        Movement numberOverFour = new NumberOverFour(randomNumberGenerator);

        new RacingController(
                new InputView(),
                new OutputView(),
                numberOverFour
        ).run();
    }
}
