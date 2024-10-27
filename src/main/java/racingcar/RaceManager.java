package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class RaceManager {
    private static final String MOVING_MARKER = "-";
    private final LinkedHashMap<String, StringBuilder> carMovementRecords = new LinkedHashMap<>();
    private final RaceOutput raceOutput;

    public RaceManager(List<String> racingCarNames, RaceOutput raceOutput) {
        this.raceOutput = raceOutput;
        for (String racingCarName : racingCarNames) {
            carMovementRecords.put(racingCarName, new StringBuilder());
        }
    }

    public void startRace(int raceCount) {
        raceOutput.printRaceStartMessage(); // RaceOutput으로
        for (int i = 0; i < raceCount; i++) {
            moveCarsForward();
            raceOutput.printRaceStatus(carMovementRecords);
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
