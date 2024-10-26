package racingcar.domain;

import java.util.*;

public class Racing {

    private final Validator validator;

    public Racing(Validator validator) {
        this.validator = validator;
    }

    public Map<String, Integer> splitCarNamesByComma(String racingCars) {
        List<String> racingCarNamesList = Arrays.stream(racingCars.split(","))
                .map(String::trim)
                .toList();

        for(String racingCarNames : racingCarNamesList) {
            validator.validateWhitespaceOrEmptyInCarNames(racingCarNames);
            validator.validateCarNameLength(racingCarNames);
        }
        validator.validateDuplicateRacingCarNames(racingCarNamesList);

        Map<String, Integer> racingCarNames = new HashMap<>();
        for(String racingCarName : racingCarNamesList) {
            racingCarNames.put(racingCarName, 0);
        }

        return racingCarNames;
    }


    public void executeRace(Map<String, Integer> racingCarNames, int racingCount) {
        for( int i = 0; i < racingCount; i++) {
            generateRandomValue();
        }
    }

    private void generateRandomValue() {

    }
}
