package racingcar.view;

public class OutputView {

    private static final String ROUND_RESULT_HEADER = "실행 결과";
    private static final String WINNER_HEADER = "최종 우승자 : ";

    public void printRoundHeader() {
        System.out.println(ROUND_RESULT_HEADER);
    }

    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public void printWinners(String winners) {
        System.out.println(WINNER_HEADER + winners);
    }
}
