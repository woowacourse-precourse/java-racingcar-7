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
        this.name = name;
        this.position = 0;
    }

    public void move(boolean shouldMove) {
        if (shouldMove) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionSymbols() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < position; i++) {
            str.append("-");
        }

        return str.toString();
    }
}
