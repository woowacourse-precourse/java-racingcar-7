package racingcar.view;

public class OutputView {

    private static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";
    private static final String GAME_PROGRESS_RESULT = "실행 결과";

    public void showWinners(String winners) {
        System.out.println(WINNER_OUTPUT_MESSAGE + winners);
    }

    public void showRoundResult(String roundResult) {
        System.out.println(GAME_PROGRESS_RESULT);
        System.out.println(roundResult);
    }
}
