package racingcar.util;

import java.util.List;

public class WinnerFormatter {

    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";

    private WinnerFormatter() {}

    public static String formatWinners(List<String> winners) {
        return WINNER_ANNOUNCEMENT_MESSAGE + String.join(", ", winners);
    }
}
