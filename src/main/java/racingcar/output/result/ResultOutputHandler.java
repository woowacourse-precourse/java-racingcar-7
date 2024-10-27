package racingcar.output.result;

import java.util.Map;

public interface ResultOutputHandler {
    void printWinner(Map<String, Integer> history);
}
