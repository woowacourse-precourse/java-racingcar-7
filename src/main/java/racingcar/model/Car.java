package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_START_POINT = 0;
    private static final int RANDOM_END_POINT = 9;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {

    }

    public void move() {

    }

    public String getPositionSymbols() {

    }
}
