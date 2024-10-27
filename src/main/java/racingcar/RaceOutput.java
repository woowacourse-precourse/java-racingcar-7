package racingcar;

import java.util.LinkedHashMap;

public class RaceOutput {
    public void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceStatus(LinkedHashMap<String, StringBuilder> carMovementRecords) {
        for (String racingCarName : carMovementRecords.keySet()) {
            System.out.println(racingCarName + " : " + carMovementRecords.get(racingCarName));
        }
        System.out.println();
    }
}
