package racingcar.view;

public class OutputView {
    static final String MESSAGE_RACE_RESULT = "실행 결과";
    static final String MOVE_PATTERN = "-";

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
}
