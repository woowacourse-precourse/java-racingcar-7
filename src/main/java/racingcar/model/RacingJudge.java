package racingcar.model;

import java.util.List;

public class RacingJudge {

    private String winners = "";
    private int maxDistance = 0;

    public String decideWinnerBy(List<RacingRecord> records) {
        for (RacingRecord record : records) {
            decideWinnerBy(record);
        }
        return winners;
    }

    private void decideWinnerBy(RacingRecord record) {
        int moveDistance = record.getMoveDistance();
        String name = record.getCarName();

        checkNewWinnerUsing(moveDistance, name);
        checkNewSoloWinnerUsing(moveDistance, name);
    }

    private void checkNewSoloWinnerUsing(int moveDistance, String name) {
        if (moveDistance > maxDistance) {
            maxDistance = moveDistance;
            winners = name;
        }
    }

    private void checkNewWinnerUsing(int moveDistance, String name) {
        if (moveDistance == maxDistance) {
            addAnotherWinner(name);
            addFirstWinner(name);
        }
    }

    private void addFirstWinner(String name) {
        if (isFirstWinner()) {
            winners += name;
        }
    }

    private void addAnotherWinner(String name) {
        if (!isFirstWinner()) {
            winners += "," + name;
        }
    }

    private boolean isFirstWinner() {
        return winners.isEmpty();
    }
}
