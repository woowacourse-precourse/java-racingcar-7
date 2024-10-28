package racingcar.executor.mover;

import java.util.Map;

public interface CarMover {
    Map<String, Integer> run(Map<String, Integer> currentHistory);
}
