package racingcar.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parsing {
    private static final String COMMA = ",";
    private static final String COMMA_SPACE = ", ";

    public static String[] splitCarName(String input) {
        return input.split(COMMA);
    }

    public static Map<String, String> convertStringArrToMap(String[] carNames) {
        Map<String, String> player = new LinkedHashMap<>();
        for (String carName : carNames) {
            player.put(carName, "");
        }
        return player;
    }

    public static String joinWinner(List<String> winners) {
        return String.join(COMMA_SPACE, winners);
    }
}
