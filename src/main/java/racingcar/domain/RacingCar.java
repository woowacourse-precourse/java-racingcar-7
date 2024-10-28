package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

public class RacingCar {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int MOVE_FORWARD_LENGTH = 1;

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    public void checkMoveForwardAndMove(MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable()) {
            moveForward();
        }
    }

    private void moveForward() {
        this.position += MOVE_FORWARD_LENGTH;
    }

    private void validateName(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new InvalidCarNameException("자동차 이름은 5글자 이하이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
