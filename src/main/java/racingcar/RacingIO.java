package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingIO {
    private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String TURN_RESULT_PROMPT = "실행 결과";
    private static final String WINNER_PROMPT = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public static void promptCarNamesInput() {
        System.out.println(CAR_NAME_INPUT_PROMPT);
    }

    public static void promptMoveCountInput() {
        System.out.println(MOVE_COUNT_INPUT_PROMPT);
    }

    public static String getInput() {
        return readLine();
    }

    public static void promptTurnResult(ArrayList<HashMap<String, Integer>> turnResults) {
        System.out.println();
        System.out.println(TURN_RESULT_PROMPT);

        for (HashMap<String, Integer> turnResult : turnResults) {
            formatTurnResult(turnResult);
            System.out.println();
        }
    }

    private static void formatTurnResult(HashMap<String, Integer> turnResult) {
        for (HashMap.Entry<String, Integer> entry : turnResult.entrySet()) {
            String carName = entry.getKey();
            int carPosition = entry.getValue();

            System.out.println(carName + " : " + "-".repeat(carPosition));
        }
    }

    public static void promptWinner(String[] winners) {
        String joinedWinners = String.join(WINNER_DELIMITER, winners);
        System.out.println(WINNER_PROMPT + joinedWinners);
    }
}
