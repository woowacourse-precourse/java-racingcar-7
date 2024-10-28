package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int INIT_DISTANCE = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(name, INIT_DISTANCE);
    }

    public void moveIfPossible() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= MOVE_THRESHOLD) {
            this.position += 1;
        }
    }
}
