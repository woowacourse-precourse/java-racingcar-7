package racingcar.output.process;

import java.util.Map;

public interface ProcessOutputHandler {
    void printFirstPhrase();
    void printHistory(Map<String, Integer> history);
}
