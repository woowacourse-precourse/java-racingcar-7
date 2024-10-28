package racingcar.service.validation;

import racingcar.service.utils.ExceptionUtils;
import racingcar.view.messages.ErrorMessageEnum;

public class AttemptNumberValidator implements InputValidator<String> {

    @Override
    public void validate(String initialInput) {
        checkEmpty(initialInput);
        checkNaturalNumber(initialInput);
    }

    private void checkNaturalNumber(String initialInput) {
        try {
            int attemptNumber = Integer.parseInt(initialInput);
            if (attemptNumber <= 0) {
                ExceptionUtils.throwIllegalArgumentException(ErrorMessageEnum.NOT_NATURAL_NUMBER_ERROR);
            }
        } catch (NumberFormatException e) {
            ExceptionUtils.throwIllegalArgumentException(ErrorMessageEnum.NOT_NATURAL_NUMBER_ERROR);
        }
    }
}
