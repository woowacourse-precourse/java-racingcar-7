package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int moveDistance;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.moveDistance = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름으로 %s는 적절하지 않습니다.", name));
        }
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (isMove(randomNum)) {
            this.moveDistance += 1;
        }
    }

    public boolean isMove(int randomNum) {
        return randomNum >= MOVE_THRESHOLD;
    }

    // -- Getter -- //
    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    // -- toString -- //
    @Override
    public String toString() {
        return String.format("%s : %s%n", name, "-".repeat(moveDistance));
    }
}
