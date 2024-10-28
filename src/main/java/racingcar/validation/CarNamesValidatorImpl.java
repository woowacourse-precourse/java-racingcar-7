package racingcar.validation;

import static racingcar.util.Constant.COMMA_DELIMITER;
import static racingcar.util.Constant.MAX_CAR_NAME_LENGTH;
import static racingcar.validation.ValidatorUtil.containsWhitespace;
import static racingcar.validation.ValidatorUtil.isEmptyInput;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.CommonUtil;

public class CarNamesValidatorImpl implements CarNamesValidator {

    @Override
    public void validate(String input) {
        validateEmptyOrBlankInput(input);
        List<String> ListOfCarNames = CommonUtil.splitToList(input, COMMA_DELIMITER);
        validateEmptyOrBlank(ListOfCarNames);
        validateDuplicateNames(ListOfCarNames);
        validateNameLength(ListOfCarNames);
    }

    private void validateEmptyOrBlankInput(String carNames) {
        if (isEmptyInput(carNames)) {
            throw new IllegalArgumentException("경주할 자동차 입력은 빈 값이나 공백일 수 없습니다.");
        }
    }

    private void validateEmptyOrBlank(Collection<String> carNames) {
        for (String carName : carNames) {
            if (isEmptyInput(carName)) {
                throw new IllegalArgumentException("자동차 이름은 빈 값이나 공백일 수 없습니다.");
            }

            if (containsWhitespace(carName)) {
                throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
            }
        }
    }

    private void validateDuplicateNames(Collection<String> carNames) {
        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNames.size() != carNameSet.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateNameLength(Collection<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
