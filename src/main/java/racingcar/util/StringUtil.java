package racingcar.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StringUtil {
    private StringUtil(){};
    public static Collection<String> splitNames(String carNames, String delimiter){
        return Arrays.stream(carNames.split(delimiter)).map(String::strip).collect(Collectors.toList());
    }
}
