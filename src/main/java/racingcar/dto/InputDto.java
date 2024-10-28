package racingcar.dto;

import racingcar.utils.validation.AttemptValidation;
import racingcar.utils.validation.CarNameValidation;

import java.util.List;

public record InputDto(List<String> inputCarNames, String inputAttempts) {

    public InputDto {
        validate(inputCarNames, inputAttempts);
    }

    private void validate(List<String> inputCarNames, String inputAttempts) {
        inputCarNames.forEach(CarNameValidation::validate);
        CarNameValidation.hasDuplicates(inputCarNames);
        AttemptValidation.validate(inputAttempts);
    }
}
