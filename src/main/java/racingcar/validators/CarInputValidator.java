package racingcar.validators;

public class CarInputValidator implements Validator {
    private static final String CAR_COUNT_ERROR = "자동차 이름이 2개 이상 필요합니다.";
    private static final String NAME_LENGTH_ERROR = "자동차 이름은 공백 포함 5자 이하여야 합니다.";

    @Override
    public void validate(String input) {
        String[] cars = input.split(",");
        checkCarCount(cars);
        checkNameLengths(cars);
    }

    private void checkCarCount(String[] cars) {
        if (cars.length < 2) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }
    }

    private void checkNameLengths(String[] names) {
        for (String name : names) {
            if (name.strip().length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
        }
    }
}
