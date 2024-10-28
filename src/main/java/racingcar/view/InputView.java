package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String NUMBER_FORMAT = "\\d+";

    public static String inputCars() {
        System.out.println(CAR_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static int inputRounds() {
        System.out.println(ROUND_INPUT_MESSAGE);
        String input = Console.readLine();
        isNumber(input);
        int rounds = Integer.parseInt(input);
        isGreaterThanZero(rounds);
        return rounds;
    }

    private static void isGreaterThanZero(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("횟수는 0보다 커야합니다.");
        }
    }

    private static void isNumber(String rounds) {
        if (!rounds.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException("횟수는 숫자형이어야 합니다.");
        }
    }
}
