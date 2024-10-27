package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String GAME_ROUND_IS_EMPTY_MESSAGE = "게임 횟수가 입력되지 않았습니다.";
    private static final String GAME_ROUND_UNDER_ONE_MESSAGE = "게임 횟수는 1 이상이어야 합니다.";
    private static final String GAME_ROUND_RANGE_IS_NOT_UNDER_INTEGER_NUMERIC_MESSAGE = "게임 횟수는 숫자이며, 정수 범위 안이어야 합니다.";

    public static String readInput() {
        printInputMessage();

        return Console.readLine();
    }

    public static int readGameRound() {
        printCountMessage();

        String counts = Console.readLine();
        int rounds;

        validateEmpty(counts);

        rounds = parseGameRound(counts);
        return rounds;
    }

    public static void close() {
        Console.close();
    }

    private static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    private static void printCountMessage() {
        System.out.println(RACING_COUNT_MESSAGE);
    }

    private static void validateEmpty(String counts) {
        if (counts.isBlank()) {
            throw new IllegalArgumentException(GAME_ROUND_IS_EMPTY_MESSAGE);
        }
    }

    private static int parseGameRound(String counts) {
        int rounds;

        try {
            rounds = Integer.parseInt(counts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAME_ROUND_RANGE_IS_NOT_UNDER_INTEGER_NUMERIC_MESSAGE);
        }

        validateRoundCount(rounds);

        return rounds;
    }

    private static void validateRoundCount(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException(GAME_ROUND_UNDER_ONE_MESSAGE);
        }
    }
}
