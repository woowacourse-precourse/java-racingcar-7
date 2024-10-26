package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    public static List<String> parse(String input){
        List<String> carNames = Arrays.asList(input.split(","));
        return carNames;
    }
}
