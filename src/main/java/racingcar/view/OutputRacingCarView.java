package racingcar.view;

public class OutputRacingCarView {
    private static final String GAME_RESULT_OUTPUT = "실행 결과\n%s";

    public void outputGameResult(String gameResult) {
        System.out.printf(GAME_RESULT_OUTPUT, gameResult);
    }
}
