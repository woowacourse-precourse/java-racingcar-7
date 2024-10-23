package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private final String COMMA = ",";

    public List<String> splitCarName(String input) {
        return Arrays.stream(input.split(COMMA)).collect(Collectors.toList());
    }

}
