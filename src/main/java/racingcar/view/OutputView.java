package racingcar.view;

public class OutputView {
    private static final String RACING_GAME_EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_CAR_STEP_RESULT_MESSAGE = "%s : %s\n";

    public static void printRacingGameExecuteResultMessage(){
        System.out.println(RACING_GAME_EXECUTE_RESULT_MESSAGE);
    }

    public static void printRacingCarStepResultMessage(String racingcarName, String steps){
        System.out.printf(RACING_CAR_STEP_RESULT_MESSAGE, racingcarName, steps);
    }

    
}
