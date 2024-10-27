package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;
    private static final int MIN_MOVE_RANGE = 1;
    private static final int MAX_MOVE_RANGE = 9;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
