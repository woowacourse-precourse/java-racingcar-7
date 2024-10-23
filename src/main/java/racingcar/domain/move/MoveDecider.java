package racingcar.domain.move;

@FunctionalInterface
public interface MoveDecider {
    boolean canMove();
}
