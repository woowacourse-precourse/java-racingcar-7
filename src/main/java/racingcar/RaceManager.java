package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class RaceManager {  // raceCount만큼 반복
    private static final String MOVING_MARKER = "-";
    private final LinkedHashMap<String, StringBuilder> carMovementRecords = new LinkedHashMap<>();

    public RaceManager(List<String> racingCarNames) {
        for (String racingCarName : racingCarNames) {
            carMovementRecords.put(racingCarName, new StringBuilder());
        }
    }

    public void moveCarsForward() {
        for (String racingCarName : carMovementRecords.keySet()) {
            if (isCarMoving()) {
                carMovementRecords.get(racingCarName).append(MOVING_MARKER);
            }
        }
    }

    private boolean isCarMoving() {
        return generateRandomNumber() >= 4;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
