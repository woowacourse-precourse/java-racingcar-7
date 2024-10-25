package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class GamePlayModel {

    public static HashMap<String, Integer> recordAttempt(HashMap<String, Integer> gameRecord) {
        for (String name : gameRecord.keySet()) {
            int move = carMoving();
            gameRecord.put(name, gameRecord.get(name) + move);
        }
        return gameRecord;
    }

    public static int carMoving() {
        int move = Randoms.pickNumberInRange(0, 9);
        if (move >= 4) {
            return 1;
        }
        return 0;
    }

}
