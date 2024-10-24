package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String RACING_GAME_EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_CAR_STEP_RESULT_MESSAGE = "%s : %s\n";
    private static final String RACING_GAME_ROUND_END_BLANK_LINE = "\n";
    private static final String RACING_GAME_WINNER_MESSAGE = "최종 우승자 : %s";
    private static final String WINNING_DELIMITER = ", ";

    public static void printRacingGameExecuteResultMessage(){
        System.out.println(RACING_GAME_EXECUTE_RESULT_MESSAGE);
    }

    public static void printRacingCarStepResultMessage(String racingcarName, String steps){
        System.out.printf(RACING_CAR_STEP_RESULT_MESSAGE, racingcarName, steps);
    }

    public static void printRacingGameRoundEndBlankLine(){
        System.out.print(RACING_GAME_ROUND_END_BLANK_LINE);
    }

    public static void printRacingGameWinner(List<String> winner) {
        System.out.printf(RACING_GAME_WINNER_MESSAGE, String.join(WINNING_DELIMITER, winner));
    }
}
