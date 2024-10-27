package racingcar.view;

import java.util.HashMap;
import java.util.Map;

public class Output {
    private static String EXCECUTION_RESULT = "\r\n실행 결과";
    private static String WINNERS_MESSAGE = "최종 우승자 : ";

    public static void printExcecutionResult() {
        System.out.println(EXCECUTION_RESULT);
    }

    public static void printEachTurnResult(HashMap<String, Integer> raceProgress) {
        for (Map.Entry<String, Integer> entry : raceProgress.entrySet()) {
            String name = entry.getKey();
            String position = getPositionBar(entry.getValue());
            System.out.println(name + " : " + position);
        }
        System.out.println();
    }

    private static String getPositionBar(int position) {
        String positionBar = "";
        for (int i = 0; i < position; i++) {
            positionBar += "-";
        }
        return positionBar;
    }

    public static void printWinners(String winners) {
        System.out.println(WINNERS_MESSAGE + winners);
    }
}
