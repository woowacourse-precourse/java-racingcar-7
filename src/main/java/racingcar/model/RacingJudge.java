package racingcar.model;

import java.util.List;

public class RacingJudge {

    public String decideWinnerBy(List<RacingRecord> records) {
        String winners = "";
        int maxDistance = 0;

        for (RacingRecord record : records) {
            int moveDistance = record.getMoveDistance();
            String name = record.getCarName();

            if (moveDistance == maxDistance) {
                if (!winners.isEmpty()) {
                    winners += "," + name;
                }
                if (winners.isEmpty()) {
                    winners += name;
                }
            }

            if (moveDistance > maxDistance) {
                maxDistance = moveDistance;
                winners = name;
            }
        }
        return winners;
    }
}
