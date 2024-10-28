package racingcar.view;

import static racingcar.common.Constants.GAME_START_PROMPT;
import static racingcar.common.Constants.PER_ROUND_PROMPT;
import static racingcar.common.Constants.RESULT_PROMPT;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    public void startRacing() {
        System.out.println(GAME_START_PROMPT);
    }

    public void getRoundResult(Cars cars, int index) {
        String roundResult = cars.getRoundResult(index);
        System.out.println(roundResult);
    }

    public void perRacing () {
        System.out.println(PER_ROUND_PROMPT);
    }

    public void showWinners(String winners) {
        System.out.println(RESULT_PROMPT + winners);

    }
}
