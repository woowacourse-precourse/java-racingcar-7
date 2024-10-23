package racingcar.service;

import static racingcar.global.error.Error.NAME_BLANK_EXCEPION;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.global.error.NameError;

public class RacingService {

    private final String COMMA = ",";

    public List<String> splitCarName(String input) {
        return Arrays.stream(input.split(COMMA)).collect(Collectors.toList());
    }

    public void validateCarName(List<String> carNames) {

        if (!validateNameNotNull(carNames)) {
            throw new NameError(NAME_BLANK_EXCEPION);
        }
    }

    private boolean validateNameNotNull(List<String> carNames) {

        return carNames.stream().allMatch(name -> name != null && !name.isEmpty());
    }

}
