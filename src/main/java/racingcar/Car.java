package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getTrack() {
        return "-".repeat(position);
    }
}
