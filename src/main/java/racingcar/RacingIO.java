package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingIO {
    private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public static void promptCarNamesInput() {
        System.out.println(CAR_NAME_INPUT_PROMPT);
    }

    public static void promptMoveCountInput() {
        System.out.println(MOVE_COUNT_INPUT_PROMPT);
    }

    public static String getInput() {
        return readLine();
    }
}
