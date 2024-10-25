package racingcar.view;

import java.util.HashMap;

public class OutputPlayView {

    private static final String MESSAGE_RESULT = "실행 결과";
    private static final String MOVING_LINE = "-";
    private static final String CAR_MOVING = "%s : ";
    private static final String NEWLINE = "\n";

    public static void outputResult() {
        System.out.println(NEWLINE + MESSAGE_RESULT);
    }

    public static void outputMoving(HashMap<String, Integer> gameRecord) {
        for (String name : gameRecord.keySet()) {
            System.out.print(String.format(CAR_MOVING, name));
            System.out.print(MOVING_LINE.repeat(gameRecord.get(name)));
            System.out.print(NEWLINE);
        }
        System.out.print(NEWLINE);
    }

}
