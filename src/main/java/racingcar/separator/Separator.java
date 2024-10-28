package racingcar.separator;

import java.util.Arrays;
import java.util.List;

public abstract class Separator {
    public static List<String> separate(String delimiter, String target) {
        String[] split = target.split(delimiter);
        return Arrays.stream(split).toList();
    }
}
