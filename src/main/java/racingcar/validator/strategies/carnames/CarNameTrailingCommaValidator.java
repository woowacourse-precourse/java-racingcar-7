package racingcar.validator.strategies.carnames;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

/**
 * 자동차 이름의 끝에 불필요한 쉼표가 있는지를 검증
 */
public class CarNameTrailingCommaValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carName) {
        validateNoTrailingComma(carName);
    }

    private void validateNoTrailingComma(String carName) {
        if (carName.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.TRAILING_COMMA.getMessage());
        }
    }

}
