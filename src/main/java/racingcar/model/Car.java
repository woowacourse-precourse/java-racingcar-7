package racingcar.model;

import java.util.Random;

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

    private void checkCarNameIsValid(String carName) {
        if (carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    private boolean isForwardable() {
        // Random 유틸을 만드는것도 좋은 생각인거같음!
        Random random = new Random();
        int randomNumber = random.nextInt(10); // 0부터 9까지의 난수를 생성

        return randomNumber > MIN_FORWARD_NUM;
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
