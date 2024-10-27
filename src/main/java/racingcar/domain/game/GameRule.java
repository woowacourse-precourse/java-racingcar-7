package racingcar.domain.game;

public interface GameRule {
    boolean moveCondition(int randomValue);

    boolean winCondition(int carPosition, int maxPosition);
}
