package racingcar.executor.util;

import java.util.HashMap;
import java.util.Map;

public class DataConverter {
    public static Map<String, Integer> convertFromStringListToStringIntegerMap(String[] input) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : input) {
            result.put(key, 0);
        }
        return result;
    }
}
