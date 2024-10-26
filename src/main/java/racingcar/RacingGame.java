package racingcar;

import java.util.List;

public interface RacingGame {
    void ready(List<String> cars);

    void start(int tryNumber);
}
