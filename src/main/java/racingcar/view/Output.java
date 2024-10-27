package racingcar.view;

import java.util.HashMap;
import java.util.Map;

public class Output {
    private static String excecutionResult = "\r\n실행 결과";
    private static String winnersMessage = "최종 우승자 : ";

    public static void printExcecutionResult() {
        System.out.println(excecutionResult);
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
        for (int i=0; i<position; i++) {
            positionBar += "-";
        }
        return positionBar;
    }

    public static void printWinners(String winners) {
        System.out.println(winnersMessage + winners);
    }
}
