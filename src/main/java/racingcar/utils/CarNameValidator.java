package racingcar.utils;

public class CarNameValidator implements Validator {
    private static final String ERROR_PREFIX = "Error: ";
    private static final int RESTRICTED_CAR_LENGTH = 4;
    private static final String RESTRICTED_CAR_NAME_LENGTH_ERROR = ERROR_PREFIX + "차량 이름은 "+RESTRICTED_CAR_LENGTH+"자리 까지만 허용합니다.";
    private static final String EMPTY_CAR_NAME_ERROR = ERROR_PREFIX + "차량 이름은 빈 문자열이나 공백은 포함할 수 없습니다.";

    @Override
    public void validation(String carName) {
        checkRestrictedLength(carName);
        checkEmptyCarName(carName);
    }

    private void checkRestrictedLength(String carName) {
        if (carName.length() > RESTRICTED_CAR_LENGTH) {
            throw new IllegalArgumentException(RESTRICTED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private void checkEmptyCarName(String carName) {
        if (carName == null || carName.contains(" ") || carName.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR);
        }
    }

}
