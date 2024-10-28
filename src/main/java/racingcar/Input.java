package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_NUMBER_MESSAGE = "시도할 횟수";
    public static String inputCarName() {
        printCarNameMessage();
        return Console.readLine();
    }

    private static void printCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static String inputTrialNumber() {
        printTrialNumberMessage();
        return Console.readLine();
    }

    private static void printTrialNumberMessage() {
        System.out.println(TRIAL_NUMBER_MESSAGE);
    }
}
