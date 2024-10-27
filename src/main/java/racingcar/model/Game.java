package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final int FIRST_ROUND = 1;

    private final List<RacingCar> players;
    private final int totalRound;
    private int currentRound;

    public Game(List<RacingCar> players, String totalRound) {
        GameValidator.validate(totalRound);

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
            if (canMove()) {
                player.move();
            }
        }
    }

    public void incrementRound() {
        this.currentRound += 1;
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_THRESHOLD;
    }

    public boolean isNotFinished() {
        return currentRound <= totalRound;
    }

    public boolean isFirstRound() {
        return currentRound == FIRST_ROUND;
    }
}
