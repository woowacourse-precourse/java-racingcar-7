package racingcar.util;

@FunctionalInterface
public interface MovementStrategy {
    boolean shouldMove();
}