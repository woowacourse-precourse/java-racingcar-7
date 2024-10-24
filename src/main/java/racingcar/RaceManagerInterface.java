package racingcar;

import java.util.List;

public interface RaceManagerInterface {
    int MIN_FORWARD_NUM = 4;

    void doRace(int times);
    List<List<String>> getLog();
}
