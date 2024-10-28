package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Reader {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String[] createCarNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        String input = Console.readLine();
        String[] carNames = input.split(",");
        Validation.checkCarNames(carNames);
        return carNames;
    }

    public static int createTryCounts() {
        System.out.println(INPUT_TRY_MESSAGE);
        String input = Console.readLine();
        return Validation.checkTryCounts(input);
    }
}
