package racingcar.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Parsing {
    private static final String DELIMITER = ",";

    public String[] splitCarName(String input) {
        return input.split(DELIMITER);
    }

    public static Map<String, String> convertStringArrToMap(String[] carNames) {
        Map<String, String> player = new LinkedHashMap<>();
        for (String carName : carNames) {
            player.put(carName, "");
        }
        return player;
    }

    public static String joinWinner(String[] winners) {
        return String.join(DELIMITER, winners);
    }
}
