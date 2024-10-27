package racingcar.domain.io;

import static racingcar.domain.racing.RacingConstant.RACING_RESULT_MESSAGE;

public class RacingOutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printRacingResult(String message) {
        System.out.println(String.format(RACING_RESULT_MESSAGE, message));
    }

    public void printIterateRacePrevMessage(String message) {
        System.out.println(message);
    }

    public void printEnter() {
        System.out.println();
    }
}
