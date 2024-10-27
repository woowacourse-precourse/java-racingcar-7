package racingcar.model;

public class CarName {
    private String carName;

    private static final int MIN_CAR_NAME = 1;
    private static final int MAX_CAR_NAME = 5;
    private static final String BLANK = " ";

    public CarName(String carName) {
        validateLength(carName);
        validateHasBlank(carName);
        this.carName = carName;
    }

    public static void validateLength(String carName) {
        if (carName.length() < MIN_CAR_NAME || carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    public static void validateHasBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
        }
    }

    public String getCarName() {
        return carName;
    }
}
