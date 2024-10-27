package racingcar;

import java.util.LinkedHashMap;
import java.util.List;

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

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
