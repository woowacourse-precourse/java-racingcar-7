package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public List<String> findCarNames(String rawNames){
        List<String> carNames = Arrays.stream(rawNames.split(","))
                .map(String::trim).toList();
        return carNames;
    }
}
