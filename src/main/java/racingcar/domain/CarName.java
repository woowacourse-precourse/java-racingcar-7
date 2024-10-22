package racingcar.domain;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private static final String BLANK = " ";
    private static final String NAME_LENGTH_ERROR = "자동차의 이름의 길이는 1 이상 " + MAX_LENGTH + "이하이어야 합니다.";
    private static final String BLANK_CONTAIN_ERROR_MESSAGE = "자동차 이름에 공백은 포함될 수 없습니다.";

    private final String carName;

    public CarName(String carName) {
        validateNameLength(carName);
        validateContainBlank(carName);
        this.carName = carName;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void validateContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_CONTAIN_ERROR_MESSAGE);
        }
    }

    public String getCarName() {
        return carName;
    }
}
