package racingcar;

import java.util.function.Function;

public class Util {
    public static Function<String, Boolean> genLongerThanX(int x) {
        return s -> s.length() > x;
    }
}
