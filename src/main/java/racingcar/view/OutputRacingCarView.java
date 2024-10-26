package racingcar.view;


public class OutputRacingCarView {
    private static final String GAME_RESULT_OUTPUT = "\n실행 결과\n%s";
    private static final String GAME_WINNERS_OUTPUT = "최종 우승자 : %s";

    public void outputGameResult(String gameResult) {
        System.out.printf(GAME_RESULT_OUTPUT, gameResult);
    }

    public void outputGameWinners(String winners) {
        System.out.printf(GAME_WINNERS_OUTPUT, winners);
    }
}
