package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame implements Game {
    private final List<Player> players;

    public RacingGame() {
        players = new ArrayList<>();
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void progress() {
        for (Player player : players) {
            player.run();
        }
    }

    @Override
    public List<String> getWinner() {
        List<String> winnerList = new ArrayList<>();

        int maxScore = 0;
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                winnerList.clear();
            }
            if (player.getScore() >= maxScore) {
                winnerList.add(player.getName());
            }
        }

        return winnerList;
    }
}
