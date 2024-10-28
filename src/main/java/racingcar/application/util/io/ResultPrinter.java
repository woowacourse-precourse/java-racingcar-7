package racingcar.application.util.io;

import java.util.List;

public final class ResultPrinter {

    private static final String FORMAT_CAR_INFORMATION = "%s\n";
    private static final String FORMAT_WINNERS = "최종 우승자 : %s\n";
    private static final String WINNERS_SEPARATOR = ", ";

    private ResultPrinter() {}

    public static void printCarInformations(List<String> informations) {
        for (String information : informations) {
            System.out.printf(FORMAT_CAR_INFORMATION, information);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        String winners = String.join(WINNERS_SEPARATOR, winnerNames);
        System.out.printf(FORMAT_WINNERS, winners);
    }

}
