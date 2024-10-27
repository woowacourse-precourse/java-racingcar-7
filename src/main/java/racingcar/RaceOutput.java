package racingcar;

import java.util.LinkedHashMap;

public class RaceOutput {
    public void printRaceStatus(LinkedHashMap<String, StringBuilder> carMovementRecords) {
            System.out.println("실행 결과");
        for (String racingCarName : carMovementRecords.keySet()) {
            System.out.println(racingCarName + " : " + carMovementRecords.get(racingCarName));
        }
    }
}
