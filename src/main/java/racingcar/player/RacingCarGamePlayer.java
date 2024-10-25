package racingcar.player;

public class RacingCarGamePlayer {
    private final String playerName;

    private RacingCarGamePlayer(String playerName) {
        this.playerName = playerName;
    }

    public static RacingCarGamePlayer createRacingCarGamePlayer(String playerName) {
        return new RacingCarGamePlayer(playerName);
    }
}
