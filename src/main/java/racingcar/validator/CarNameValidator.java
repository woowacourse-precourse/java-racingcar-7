package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    public CarNameValidator() {
    }

    public void validateCarNames(String input) {
        validateNotBlank(input);
        validateNoSpace(input);
        validateDelimiter(input);
        validateEnd(input);
        String[] carNames = input.split(",");
        Set<String> nameSet = new HashSet<>();
        for (String carName : carNames) {
            validateEmptyName(carName);
            validateCarNameLength(carName);
            nameSet.add(carName);
        }
        validateDuplication(nameSet.size(), carNames.length);
    }

    void validateCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    void validateEnd(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("입력의 마지막은 콤마(,)로 끝날 수 없습니다.");
        }
    }

    void validateDelimiter(String input) {
        String regex = "^[^,]*$";
        if (input.matches(regex)) {
            throw new IllegalArgumentException("자동차 이름들은 콤마로 구분해야합니다.");
        }
    }

    void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    void validateNoSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함될 수 없습니다.");
        }
    }

    void validateDuplication(int carSetSize, int carArrayLength) {
        if (carSetSize != carArrayLength) {
            throw new IllegalArgumentException("자동차 이름에 중복이 존재합니다.");
        }
    }

    void validateEmptyName(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 빈 값일 수 없습니다.");
        }
    }

}
