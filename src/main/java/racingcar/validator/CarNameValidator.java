package racingcar.validator;

import racingcar.model.CarNames;
import racingcar.validator.exception.InvalidCarNameException;

public class CarNameValidator implements Validator<CarNames> {
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(CarNames names) {
        validateNotBlank(names);
        validateNameLength(names);
        validateUniqueNames(names);
    }

    private void validateNotBlank(CarNames names) {
        for (String name : names.getNames()) {
            if (name == null || name.isBlank()) {
                throw new InvalidCarNameException("차 이름은 공백일 수 없습니다.");
            }
        }
    }

    private void validateNameLength(CarNames names) {
        for (String name : names.getNames()) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new InvalidCarNameException("차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
            }
        }
    }

    private void validateUniqueNames(CarNames names) {
        long distinctCount = names.getNames().stream().distinct().count();
        if (distinctCount < names.getNames().size()) {
            throw new InvalidCarNameException("차 이름에 중복된 값이 있습니다.");
        }
    }

}
