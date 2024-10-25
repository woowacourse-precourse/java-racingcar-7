package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Map;
import racingcar.view.OutputView;

public class RacingCarService {
    private final int LOW_NUM = 0;
    private final int HIGH_NUM = 9;
    private final int STAND_NUM = 4;

    public RacingCarService(Map<String, Integer> carList, Integer tryCount) {
        while (tryCount--> 0) {
        }
    }


    private int createRandomNumber() {
        return Randoms.pickNumberInRange(LOW_NUM, HIGH_NUM);
    }
}
