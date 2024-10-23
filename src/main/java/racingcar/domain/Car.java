package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int PICK_NUMBER_IN_RANGE_MIN = 0;
    private static final int PICK_NUMBER_IN_RANGE_MAX = 9;
    private static final int FORWARD_STANDARD = 4;
    private static final int CAR_SPEED = 1;
    private final String carName;
    private int position;

    public Car(String name) {
        validationEmptyName(name);
        validationNameLength(name);
        this.position = 0;
        this.carName = name;
    }

    private void validationEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validationNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void randomMove() {
        int random = Randoms.pickNumberInRange(PICK_NUMBER_IN_RANGE_MIN, PICK_NUMBER_IN_RANGE_MAX);
        if(random >= FORWARD_STANDARD) {
            this.position += CAR_SPEED;
        }
    }
}
