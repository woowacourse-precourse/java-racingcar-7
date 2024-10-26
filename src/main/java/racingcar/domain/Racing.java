package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    private final Validator validator;

    public Racing(Validator validator) {
        this.validator = validator;
    }

    public Set<String> splitCarNamesByComma(String racingCars) {
        List<String> racingCarNamesList = Arrays.stream(racingCars.split(","))
                .map(String::trim)
                .toList();

        for(String racingCarNames : racingCarNamesList) {
            validator.validateWhitespaceOrEmptyInCarNames(racingCarNames);
            validator.validateCarNameLength(racingCarNames);
        }

        Set<String> racingCarNames = new HashSet<>(racingCarNamesList);
        validator.validateDuplicateRacingCarNames(racingCarNamesList, racingCarNames);

        return racingCarNames;
    }
}
