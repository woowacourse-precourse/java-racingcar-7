package racingcar.view;

import java.util.List;

public class OutputView {
    static final String MESSAGE_RACE_RESULT = "실행 결과";
    static final String MOVE_PATTERN = "-";
    static final String MESSAGE_WINNER = "최종 우승자 : ";

    public void printLine() {
        System.out.println();
    }

    public void printResultMessage() {
        System.out.println(MESSAGE_RACE_RESULT);
    }

    public void printCurrentDistance(String name, int distance) {
        String stringBuilder = name
                + " : "
                + makeMovePatternFromDistance(distance);
        System.out.println(stringBuilder);
    }

    private String makeMovePatternFromDistance(int number) {
        return MOVE_PATTERN.repeat(Math.max(0, number));
    }

    public void printWinners(List<String> winners) {
        System.out.print(MESSAGE_WINNER);
        String result = String.join(", ", winners);
        System.out.println(result);
    }

}
