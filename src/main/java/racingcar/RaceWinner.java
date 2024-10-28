package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceWinner {
    public static String findWinner() {
        String[] finalMovements = MoveDecider.move().split("\n");

        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (String movement : finalMovements) {
            String[] parts = movement.split(" : ");
            if (parts.length < 2) {
                continue;
            }

            String carName = parts[0];
            String movementRecord = parts[1];

            int distance = movementRecord.length();

            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(carName);
            } else if (distance == maxDistance) {
                winners.add(carName);
            }
        }
        String winnerResult = "최종 우승자: " + String.join(", ", winners);
        System.out.println(winnerResult);
        return winnerResult;

    }
}
