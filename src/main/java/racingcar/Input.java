package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String[] inputCarNames() {

        System.out.println(INPUT_NAME_MESSAGE);
        String[] carNames = splitCarNames(Console.readLine());
        Validation.validateCarNames(carNames);
        return carNames;
    }

    private static String[] splitCarNames(String input) {
        return input.split(",");
    }

    public static int inputTryCounts() {
        System.out.println(INPUT_TRY_MESSAGE);
        String input = Console.readLine();
        return Validation.validateTryCounts(input);
    }
}
