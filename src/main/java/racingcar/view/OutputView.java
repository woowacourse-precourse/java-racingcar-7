package racingcar.view;

import java.util.List;

public class OutputView {
    static final String RACE_RESULT_MESSAGE = "실행 결과";
    static final String MOVE_SYMBOL = "-";
    static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printLine() {
        System.out.println();
    }

    public void printResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void printCurrentDistance(String name, int distance) {
        String stringBuilder = name
                + " : "
                + makeMovePatternFromDistance(distance);
        System.out.println(stringBuilder);
    }

    private String makeMovePatternFromDistance(int number) {
        return MOVE_SYMBOL.repeat(Math.max(0, number));
    }

    public void printWinners(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        String result = String.join(", ", winners);
        System.out.println(result);
    }

}
