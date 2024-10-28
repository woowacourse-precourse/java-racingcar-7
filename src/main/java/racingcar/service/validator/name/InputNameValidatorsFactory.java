package racingcar.service.validator.name;

import java.util.List;

public class InputNameValidatorsFactory {
    public static List<InputNameValidator> create() {
        return List.of(
                new InputNameCountValidator(),
                new InputNameCharacterValidator(),
                new InputNameDuplicationValidator(),
                new InputNameLengthValidator()
        );
    }
}
