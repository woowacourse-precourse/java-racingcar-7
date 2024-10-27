package racingcar.service;

import java.util.List;
import racingcar.model.dto.RacingRequestDTO;
import racingcar.service.validator.name.InputNameValidator;
import racingcar.service.validator.name.InputNameValidatorsFactory;
import racingcar.service.validator.round.InputRoundValidator;
import racingcar.service.validator.round.InputRoundValidatorsFactory;

public class ValidatorService {
    public void validate(RacingRequestDTO racingRequestDTO) {
        validateInputNames(racingRequestDTO.getInputNames());
        validateInputRound(racingRequestDTO.getRoundCount());
    }

    private void validateInputNames(String inputNames) {
        for (InputNameValidator inputNameValidator : createInputNameValidators()) {
            inputNameValidator.validate(inputNames);
        }
    }

    private void validateInputRound(String roundCount) {
        for (InputRoundValidator inputRoundValidator : createInputRoundValidators()) {
            inputRoundValidator.validate(roundCount);
        }
    }

    private List<InputNameValidator> createInputNameValidators() {
        return InputNameValidatorsFactory.create();
    }

    private List<InputRoundValidator> createInputRoundValidators() {
        return InputRoundValidatorsFactory.create();
    }

}
