package racingcar.model;

@FunctionalInterface
public interface MoveDecider {
    boolean canMove();
}
