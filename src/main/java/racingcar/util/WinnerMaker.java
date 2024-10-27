package racingcar.util;

import racingcar.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class WinnerMaker {

    public static String createWinner(List<Player> playerList) {
        List<String> winners = new ArrayList<>();
        int maxScore = maxScore(playerList);
        for (Player player : playerList) {
            if (player.getScore() == maxScore) {
                winners.add(player.getName());
            }
        }
        // 출력: pobi, java
        return String.join(", ", winners);
    }

    private static int maxScore(List<Player> playerList) {
        int maxScore = 0;
        for (Player player : playerList) {
            maxScore = Math.max(player.getScore(), maxScore);
        }
        return maxScore;
    }
}
