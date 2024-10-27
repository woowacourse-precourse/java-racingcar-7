package racingcar.domain;

public class GameRule {
    private final int gameLimit;

    public GameRule(int gameLimit) {
        this.gameLimit = gameLimit;
    }

    public int getGameLimit() {
        return gameLimit;
    }

    public boolean moveForward(int randomNumber) {
        return randomNumber >= 4;
    }
}