package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.LinkedHashMap;

public class GameManager {

    public LinkedHashMap<String, Integer> gameProgress(LinkedHashMap<String, Integer> gameEntry) {
        return moveForward(gameEntry);
    }

    private LinkedHashMap<String, Integer> moveForward(LinkedHashMap<String, Integer> gameEntry) {
        for (String carName : gameEntry.keySet()) {
            if (checkMove()) {
                gameEntry.put(carName, gameEntry.get(carName) + 1);
            }
        }
        return gameEntry;
    }

    private Boolean checkMove() {
        return randomGenerator() > 3;
    }

    private Integer randomGenerator() {
        return pickNumberInRange(0, 9);
    }
}