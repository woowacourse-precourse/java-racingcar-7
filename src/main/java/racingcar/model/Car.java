package racingcar.model;

import racingcar.util.RandomUtil;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MIN_FORWARD_NUM = 4;

    private final String carName;
    private int forwardCount;

    public Car(String carName) {
        checkCarNameIsValid(carName);
        this.carName = carName;
        this.forwardCount = 0;
    }

    public String forwardProcess() {
        if (isForwardable()) {
            this.forwardCount++;
        }
        String progress = "-".repeat(forwardCount);

        return carName + " : " + progress;
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    private void checkCarNameIsValid(String carName) {
        if (carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    private boolean isForwardable() {
        return RandomUtil.getRandomNumber() > MIN_FORWARD_NUM;
    }
}
