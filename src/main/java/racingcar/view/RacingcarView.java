package racingcar.view;

import racingcar.dto.RacingcarResults;
import racingcar.dto.UserInput;

import java.util.List;

public interface RacingcarView {

    UserInput getInput();

    void printOutput(RacingcarResults result);

    void printResult(List<String> winner);
}
