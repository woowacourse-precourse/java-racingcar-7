package racingcar.view;

public class OutputView {

    private static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    public void showWinners(String winners) {
        System.out.println(WINNER_OUTPUT_MESSAGE + winners);
    }

    public void showRoundResult(String roundResult) {
        System.out.println(roundResult);
    }
}
