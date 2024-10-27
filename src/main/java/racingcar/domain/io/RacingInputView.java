package racingcar.domain.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.racing.RacingConstant;

public class RacingInputView {

    private final RacingOutputView racingOutputView;

    public RacingInputView(RacingOutputView racingOutputView) {
        this.racingOutputView = racingOutputView;
    }

    public String readRacingCarNames() {
        racingOutputView.printMessage(RacingConstant.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String readTryCount() {
        racingOutputView.printMessage(RacingConstant.INPUT_TRY_COUNT_MESSAGE);
        return Console.readLine();
    }
}
