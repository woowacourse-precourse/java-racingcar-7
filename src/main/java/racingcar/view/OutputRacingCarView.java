package racingcar.view;


public class OutputRacingCarView {
    private static final String GAME_RESULT_OUTPUT = "\n실행 결과\n%s";
    private static final String GAME_WINNERS_OUTPUT = "최종 우승자 : %s";
    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_MOVE_COUNT_INPUT = "시도할 횟수는 몇 회인가요?";

    public void printCarNameInputText(){
        System.out.println(CAR_NAME_INPUT);
    }
    public void printCarMoveCountInputText(){
        System.out.println(CAR_MOVE_COUNT_INPUT);
    }

    public void printGameResult(String gameResult) {
        System.out.printf(GAME_RESULT_OUTPUT, gameResult);
    }

    public void printGameWinners(String winners) {
        System.out.printf(GAME_WINNERS_OUTPUT, winners);
    }
}
