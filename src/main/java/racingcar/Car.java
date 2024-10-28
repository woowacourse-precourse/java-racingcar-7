package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int START_POSITION = 0;
    private static final int END_POSITION = 9;
    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        validateName();
    }

    private void validateName() {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if (Randoms.pickNumberInRange(START_POSITION, END_POSITION) >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
