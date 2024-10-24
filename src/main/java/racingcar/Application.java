package racingcar;

import java.util.Arrays;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        String[] carNames = inputView.inputCarNames().split(",");
        int raceRound = inputView.inputRaceRound();

        RacingCarController racingCarController = new RacingCarController();
        racingCarController.racing(Arrays.asList(carNames), raceRound);
    }
}
