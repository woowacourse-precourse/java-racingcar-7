package racingcar.service.validator.round;

import java.util.List;

public class InputRoundValidatorsFactory {
    public static List<InputRoundValidator> create() {
        return List.of(
                new InputRoundFormatValidator(),
                new InputRoundRangeValidator()
        );
    }
}
