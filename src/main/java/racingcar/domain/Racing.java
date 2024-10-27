package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class Racing {
    
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    
    public void start(HashMap<String, Integer> racingLog, List<String> carNameList) {
        for (String carName : carNameList) {
            int racingResult = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            int moveCount = racingLog.getOrDefault(carName, 0);
            if (racingResult >= 4) {
                racingLog.put(carName, moveCount + 1);
            }
        }
    }
}
