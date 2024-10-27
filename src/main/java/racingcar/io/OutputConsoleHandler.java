package racingcar.io;

import java.util.List;

public class OutputConsoleHandler {

    public static final String FINAL_WINNERS_DELIMITER = ",";
    public static final String WINNERS_PREFIX = "최종 우승자 : ";

    public void showCurrentCarStatus(String view) {
        System.out.println(view);
    }

    public void showFinalWinnerNames(List<String> winnerNames) {

        String winnerNamesJoining = String.join(FINAL_WINNERS_DELIMITER, winnerNames);

        System.out.println(WINNERS_PREFIX + winnerNamesJoining);
    }
}
