package racingcar.util;

import java.util.List;

public class MessageFormatter {

    public static String getWinnersName(List<String> winners) {
        return String.join(", ", winners);
    }

    public static String getCarInformation(String name, int status) {
        return name + " : " + "-".repeat(status);
    }
}
