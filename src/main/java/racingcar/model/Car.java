package racingcar.model;

public class Car {
    private static final String KOREAN_ENGLISH_REGEX = "^[a-zA-Z가-힣]+$";
    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarName(String carName) {
        validateGap(carName);
        validateLanguage(carName);
        validateNameLength(carName);
    }

    private void validateGap(String carName) {
        if(carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateLanguage(String carName) {
        if(!carName.matches(KOREAN_ENGLISH_REGEX)) {
            throw new IllegalArgumentException("자동차 이름은 한글과 영어만 포함해야합니다.");
        }
    }

    private void validateNameLength(String carName) {
        if(carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
