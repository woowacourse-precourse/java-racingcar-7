package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAMES_INPUT_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_INPUT_VIEW = "시도할 횟수는 몇 회인가요?";

    public static String readCarNames() {
        System.out.println(CAR_NAMES_INPUT_VIEW);
        String input = Console.readLine().trim();

        return input;
    }

    public static int readRaceCount() {
        System.out.println(RACE_COUNT_INPUT_VIEW);
        int input = Integer.parseInt(Console.readLine().trim());
        Console.close();

        return input;
    }

}
