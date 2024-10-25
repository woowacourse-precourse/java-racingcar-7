package racingcar.model;

import racingcar.controller.strategy.MoveStrategy;

public class Car {

    private final Name name;
    private final MoveStrategy moveStrategy;
    private int position;

    public Car(final String name, final MoveStrategy moveStrategy, final int position) {
        this.name = new Name(name);
        this.moveStrategy = moveStrategy;
        validateSize(position);
        this.position = position;
    }

    private void validateSize(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException("초기 위치는 음수가 될 수 없습니다.");
        }
    }

    public void attemptMove() {
        if (moveStrategy.isMovable()) {
            this.move();
        }
    }

    private void move() {
        this.position += 1;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }
}
