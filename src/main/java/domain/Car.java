package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final String MAXIMUM_NAME_SIZE_ERROR_MESSAGE = "자동차 이름은 5글자 이하로 입력해야 합니다";
    private static final String NAME_EMPTY_ERROR_MESSAGE = "올바른 자동차 이름을 입력해야 합니다.";
    private static final Integer MIN_MOVE_COUNT = 4;
    private static final Integer MAXIMUM_NAME_SIZE = 6;

    private final String name;
    private int status;

    public Car(final String name) {
        validateEmpty(name);
        validateNameSize(name);
        this.name = name;
        this.status = 0;
    }

    public void validateNameSize(final String name) {
        if(name.length() >= MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException(MAXIMUM_NAME_SIZE_ERROR_MESSAGE);
        }
    }

    public void validateEmpty(final String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException(NAME_EMPTY_ERROR_MESSAGE);
        }
    }

    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if(number >= MIN_MOVE_COUNT) {
            status++;
        }
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}
