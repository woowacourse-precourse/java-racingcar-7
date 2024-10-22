package racingcar.model;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;
    private int forwardCount;

    public Car(String carName) {
        checkCarNameIsValid(carName);
        this.carName = carName;
        this.forwardCount = 0;
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
}
