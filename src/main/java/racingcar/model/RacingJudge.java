package racingcar.model;

import java.util.List;

public class RacingJudge {

    private static String winners = "";
    private static int maxDistance = 0;

    public RacingJudge() {
        winners = "";
        maxDistance = 0;
    }

    public static String decideWinnerBy(List<RacingRecord> records) {
        for (RacingRecord record : records) {
            decideWinnerBy(record);
        }
        return winners;
    }

    private static void decideWinnerBy(RacingRecord record) {
        int moveDistance = record.getMoveDistance();
        String name = record.getCarName();

        checkNewWinnerUsing(moveDistance, name);
        checkNewSoloWinnerUsing(moveDistance, name);
    }

    private static void checkNewSoloWinnerUsing(int moveDistance, String name) {
        if (moveDistance > maxDistance) {
            maxDistance = moveDistance;
            winners = name;
        }
    }

    private static void checkNewWinnerUsing(int moveDistance, String name) {
        if (moveDistance == maxDistance) {
            addAnotherWinner(name);
            addFirstWinner(name);
        }
    }

    private static void addFirstWinner(String name) {
        if (isFirstWinner()) {
            winners += name;
        }
    }

    private static void addAnotherWinner(String name) {
        if (!isFirstWinner()) {
            winners += "," + name;
        }
    }

    private static boolean isFirstWinner() {
        return winners.isEmpty();
    }
}
