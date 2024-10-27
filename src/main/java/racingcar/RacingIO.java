package racingcar;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingIO {
    private static final String WINNER_DELIMITER = ", ";

    private enum Messages {
        CAR_NAME_INPUT_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        MAX_TURN_INPUT_PROMPT("시도할 횟수는 몇 회인가요?"),
        TURN_RESULT_PROMPT("실행 결과"),
        WINNER_PROMPT("최종 우승자 : ");

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public static void promptCarNameInput() {
        System.out.println(Messages.CAR_NAME_INPUT_PROMPT.getMessage());
    }

    public static void promptMaxTurnInput() {
        System.out.println(Messages.MAX_TURN_INPUT_PROMPT.getMessage());
    }

    public static String getInput() {
        return readLine();
    }

    public static void printRaceResult(LinkedList<LinkedHashMap<String, Integer>> raceResult) {
        System.out.println();
        System.out.println(Messages.TURN_RESULT_PROMPT.getMessage());

        for (LinkedHashMap<String, Integer> turnResult : raceResult) {
            printTurnResult(turnResult);
            System.out.println();
        }
    }

    private static void printTurnResult(LinkedHashMap<String, Integer> turnResult) {
        turnResult.forEach((carName, carPosition) ->
                System.out.println(carName + " : " + "-".repeat(carPosition))
        );
        System.out.println();
    }

    public static void promptWinner(String[] winners) {
        String joinedWinners = String.join(WINNER_DELIMITER, winners);
        System.out.println(Messages.WINNER_PROMPT.getMessage() + joinedWinners);
    }
}
