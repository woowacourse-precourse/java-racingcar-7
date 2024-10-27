package racingcar;

/**
 * 자동차 전진 조건을 나타내는 인터페이스
 */
@FunctionalInterface
public interface MoveCondition {
    boolean canMove();
}
