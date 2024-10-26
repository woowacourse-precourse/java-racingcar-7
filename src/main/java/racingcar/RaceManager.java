package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class RaceManager {  // raceCount만큼 반복
    private final LinkedHashMap<String, StringBuilder> carMovementRecords = new LinkedHashMap<>();

    public RaceManager(List<String> racingCarNames) {
        for (String racingCarName : racingCarNames) {
            carMovementRecords.put(racingCarName, new StringBuilder());
        }
    }

    private boolean isCarMoving() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= 4;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
