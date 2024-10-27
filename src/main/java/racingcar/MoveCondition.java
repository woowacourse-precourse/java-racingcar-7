package racingcar;

/**
 * 자동차 전진 조건을 나타내는 인터페이스. 이 MoveCondition 인터페이스를 구현하는 클래스는 자동차 경주 규칙에 따라 전진할 수 있는지 여부를 판단해야 한다. (such as {@link RandomMoveCondition#canMove()})
 */
@FunctionalInterface
public interface MoveCondition {
    boolean canMove();
}
