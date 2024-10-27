package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

import static racingcar.common.Symbol.HYPHEN;

public class Racing {
    
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    
    public void start(HashMap<String, StringBuilder> racingLog, List<String> carNameList) {
        for (String carName : carNameList) {
            int racingResult = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            StringBuilder moveCount = racingLog.getOrDefault(carName, new StringBuilder());
            if (racingResult >= 4) {
                racingLog.put(carName, moveCount.append(HYPHEN));
            }
        }
    }
}
