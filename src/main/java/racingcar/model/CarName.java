package racingcar.model;

public class CarName {
    private String carName;
    private static String BLANK_NAME_ERROR_MESSAGE = "빈 자동차 이름은 입력할 수 없습니다.";
    private static String OVER_FIVE_NAME_ERROR_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_ERROR_MESSAGE);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(OVER_FIVE_NAME_ERROR_MESSAGE);
        }
    }

    public String getCarName() {
        return this.carName;
    }
}