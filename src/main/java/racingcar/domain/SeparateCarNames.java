package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeparateCarNames {
    public static List<String> separateCarNames(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(",", -1)).collect(Collectors.toList());
    }
}
