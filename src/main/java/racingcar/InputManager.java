package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String GAME_ROUND_IS_EMPTY_MESSAGE = "게임 횟수가 입력되지 않았습니다.";
    private static final String GAME_ROUND_UNDER_ONE_MESSAGE = "게임 횟수는 1 이상이어야 합니다.";
    private static final String GAME_ROUND_RANGE_UNDER_INTEGER_MESSAGE = "게임 횟수는 정수 범위 안 이어야 합니다.";
    private static final String GAME_ROUND_IS_NOT_NUMERIC_MESSAGE = "게임 횟수 입력값이 숫자가 아닙니다.";

    public static List<Name> getInput() {
        getInputMessage();

        String input = Console.readLine();

        Names names = new Names(input);

        return names.getNames();
    }

    //game class 에서 처리
    public static int getGameRound() {
        getCountMessage();

        String counts = Console.readLine();

        int rounds;
        if (counts.isEmpty() || counts.equals(" ")) {
            throw new IllegalArgumentException(GAME_ROUND_IS_EMPTY_MESSAGE);
        }
        for (int i = 0; i < counts.length(); i++) {
            if (!Character.isDigit(counts.charAt(i))) {
                throw new IllegalArgumentException(GAME_ROUND_IS_NOT_NUMERIC_MESSAGE);
            }
        }
        try {
            rounds = Integer.parseInt(counts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAME_ROUND_RANGE_UNDER_INTEGER_MESSAGE);
        }
        if (rounds <= 0) {
            throw new IllegalArgumentException(GAME_ROUND_UNDER_ONE_MESSAGE);
        }
        return rounds;
    }

    public static void close() {
        Console.close();
    }

    private static void getInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    private static void getCountMessage() {
        System.out.println(RACING_COUNT_MESSAGE);
    }
}
