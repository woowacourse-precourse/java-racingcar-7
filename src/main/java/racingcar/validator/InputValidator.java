package racingcar.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.validator.strategies.CarNameValidator;
import racingcar.validator.strategies.TryCountValidator;

public class InputValidator {

    private final CarNameValidator carNameValidator;
    private final TryCountValidator tryCountValidator;

    public InputValidator() {
        this.carNameValidator = new CarNameValidator();
        this.tryCountValidator = new TryCountValidator();
    }

    public List<String> validateAndParseCarNames(String carNamesInput) {
        carNameValidator.validate(carNamesInput);
        return parseCarNames(carNamesInput);
    }

    public int validateAndParseTryCount(String tryCountInput) {
        tryCountValidator.validate(tryCountInput);
        return parseTryCount(tryCountInput);
    }

    private List<String> parseCarNames(String carNamesInput) {
        return Stream.of(carNamesInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private int parseTryCount(String tryCountInput) {
        return Integer.parseInt(tryCountInput);
    }

}
