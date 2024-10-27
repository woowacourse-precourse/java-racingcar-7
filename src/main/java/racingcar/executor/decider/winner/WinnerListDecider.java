package racingcar.executor.decider.winner;

import java.util.List;
import java.util.Map;

public interface WinnerListDecider {
    List<String> findWinners(Map<String, Integer> history);
}
