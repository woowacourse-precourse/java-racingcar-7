package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.(기능 요구 사항 3번)");
        }
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }
}
