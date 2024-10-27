package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRIAL_COUNTS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String inputTrialCounts() {
        System.out.println(INPUT_TRIAL_COUNTS_MESSAGE);
        String trialCounts = Console.readLine();
        closeConsole();
        return trialCounts;
    }

    private static void closeConsole() {
        Console.close();
    }
}
