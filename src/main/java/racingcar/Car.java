package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private static final int FORWARD_THRESHOLD = 4;
    private int position = 0;


    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 값일수 없습니다");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다");
        }

    }

    public String getName() {
        return name;
    }

    public void tryMove() {
        if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
            position++;
        }
    }

}
