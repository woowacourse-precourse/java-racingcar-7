package racingcar.model.service.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;
import racingcar.model.service.validator.RacingcarValidator;

public class RacingcarConverter {

    private static final String DELIMITER = ",";
    private final RacingcarValidator racingcarValidator;

    public RacingcarConverter() {
        this.racingcarValidator = new RacingcarValidator();
    }

    public List<Car> convertToCars(String carNamesInput) {
        racingcarValidator.validateSplitCarNames(carNamesInput, DELIMITER);
        return Arrays.stream(carNamesInput.split(DELIMITER))
                .map(String::trim)
                .peek(racingcarValidator::validateCarNameLength)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Integer convertToNumber(String attemptCountInput) {
        racingcarValidator.validateAttemptCount(attemptCountInput);
        return Integer.parseInt(attemptCountInput);
    }
}
