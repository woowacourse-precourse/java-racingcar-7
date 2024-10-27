package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int FIRST_ROUND = 1;
    private static final int ERROR_POSITION = -1;

    private final List<RacingCar> players;
    private final int totalRound;
    private int currentRound;

    public RacingGame(List<RacingCar> players, String totalRound) {
        RacingGameValidator.validate(totalRound);

        this.players = players;
        this.totalRound = Integer.parseInt(totalRound);
        this.currentRound = FIRST_ROUND;
    }

    public List<RacingCar> getPlayers() {
        return players;
    }

    public int getTotalRound() {
        return totalRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void play() {
        for (RacingCar player : players) {
            if (player.canMove()) {
                player.move();
            }
        }
    }

    public void incrementRound() {
        currentRound += 1;
    }

    public boolean isNotFinished() {
        return currentRound <= totalRound;
    }

    public boolean isFirstRound() {
        return currentRound == FIRST_ROUND;
    }

    public List<RacingCar> findFinalWinners() {
        int maxPosition = players.stream().mapToInt(RacingCar::getPosition).max().orElse(ERROR_POSITION);

        return players.stream().filter(player -> player.getPosition() == maxPosition).collect(Collectors.toList());
    }
}
