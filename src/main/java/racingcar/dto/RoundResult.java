package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Player;

public class RoundResult {
    private final List<PlayerStat> playerStats;

    public RoundResult(List<PlayerStat> playerStats) {
        this.playerStats = playerStats;
    }

    public static RoundResult createRoundResult(int round, List<Player> players) {
        List<PlayerStat> playerStats = new ArrayList<>();
        for (Player player : players) {
            playerStats.add(new PlayerStat(round, player.getCarName(), player.getPosition()));
        }
        return new RoundResult(playerStats);
    }

    public List<PlayerStat> getPlayerStats() {
        return playerStats;
    }
}
