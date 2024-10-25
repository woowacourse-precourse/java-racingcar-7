package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinnerModel {

    public static List<String> gameWinner(HashMap<String, Integer> gameRecord) {
        int max = findMax(gameRecord);
        List<String> winners = findWinners(gameRecord, max);
        return winners;
    }

    public static int findMax(HashMap<String, Integer> gameRecord) {
        int max = 0;
        for (String name : gameRecord.keySet()) {
            max = compareMax(max, gameRecord.get(name));
        }
        return max;
    }

    public static int compareMax(int max, int compare) {
        if (max > compare) {
            return max;
        }
        return compare;
    }

    public static List<String> findWinners(HashMap<String, Integer> gameRecord, int max) {
        List<String> winners = new ArrayList<>();
        for (String name : gameRecord.keySet()) {
            if (isWinner(gameRecord.get(name), max)) {
                winners.add(name);
            }
        }
        return winners;
    }

    public static boolean isWinner(int value, int max) {
        if (value == max) {
            return true;
        }
        return false;
    }

}
