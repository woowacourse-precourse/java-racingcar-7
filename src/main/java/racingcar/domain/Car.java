package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_NUMBER_RANGE_MIN = 0;
    private static final int RANDOM_NUMBER_RANGE_MAX = 9;
    private static final String DISPLAY_POSITION_FORMAT = " : ";
    private static final String POSITION_MARKER = "-";

    private final String name;
    private int position;
    private final StringBuilder displayPosition;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.displayPosition = new StringBuilder(getName()).append(DISPLAY_POSITION_FORMAT);
    }

    public void move() {
        if (generateRandomNumber() >= MOVE_THRESHOLD) {
            this.position++;
            updateDisplayPosition();
        }
    }

    // 이동의 기준이 되는 랜덤 넘버 생성
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_MIN, RANDOM_NUMBER_RANGE_MAX);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getDisplayPosition() {
        return displayPosition.toString();
    }

    private void updateDisplayPosition() {
        displayPosition.append(POSITION_MARKER);
    }
}
