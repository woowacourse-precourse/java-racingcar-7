package racingcar.view;

import racingcar.dto.RacingcarResults;
import racingcar.dto.UserInput;

public interface RacingcarView {

    UserInput getInput();

    void printOutput(RacingcarResults result);
}
