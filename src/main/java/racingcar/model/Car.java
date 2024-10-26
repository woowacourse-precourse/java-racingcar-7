package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MINIMUM_MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private String name;
    private int moveDistance;

    public Car(String name) {
        validateCarNameLengthAndBlank(name);
        this.name = name;
        this.moveDistance = 0;
    }

    public void validateCarNameLengthAndBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자리 이하로 입력해주세요.");
        }
    }

    public void move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MINIMUM_MOVE_THRESHOLD) {
            moveDistance ++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
