package racingcar.controller.validation;

import racingcar.view.messages.ErrorMessageEnum;

public class AttemptNumberValidator implements InputValidator<String> {

    @Override
    public int validate(String initialInput) {
        checkEmpty(initialInput);
        return checkNaturalNumber(initialInput);
    }

    // TODO: enum 호출 넘 길다..
    private int checkNaturalNumber(String initialInput) {
        try {
            int attemptNumber = Integer.parseInt(initialInput);
            if (attemptNumber <= 0) {
                throw new IllegalArgumentException(ErrorMessageEnum.NOT_NATURAL_NUMBER_ERROR.getErrorMessage());
            }
            return attemptNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageEnum.NOT_NATURAL_NUMBER_ERROR.getErrorMessage());
        }
    }
}
