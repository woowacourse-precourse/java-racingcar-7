package racingcar;

import java.util.List;

public interface RaceManagerInterface {
    int MIN_FORWARD_NUM = 4;
    int MIN_DICE_NUM = 0;
    int MAX_DICE_NUM = 9;

    void doRace(int times);

    List<List<String>> getLog();

    List<String> getWinner();

}
