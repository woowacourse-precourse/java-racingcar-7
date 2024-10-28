package racingcar.util;

import java.util.List;

public class MessageFormatter {

    private final static String NAME_STATUS_DELIMITER = " : ";
    private final static String STATUS_BAR = "-";

    public static String getWinnersName(List<String> winners) {
        return String.join(", ", winners);
    }

    public static String getCarInformation(String name, int status) {
        return name + NAME_STATUS_DELIMITER + STATUS_BAR.repeat(status);
    }
}
