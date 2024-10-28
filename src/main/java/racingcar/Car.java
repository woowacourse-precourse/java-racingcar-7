package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;
    private final int MOVE_STANDARD = 4;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다");
        }
    }

    public int move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= MOVE_STANDARD) {
            position++;
        }
        return randomNum;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
