package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";
    public static String inputCarName() {
        printCarNameMessage();
        String inputCarName = Console.readLine();
        validateInputCarName(inputCarName);
        return inputCarName;
    }

    private static void printCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static String inputTrialNumber() {
        printTrialNumberMessage();
        String inputTrialNumber = Console.readLine();
        validateNull(inputTrialNumber);
        return inputTrialNumber;
    }

    private static void printTrialNumberMessage() {
        System.out.println(TRIAL_NUMBER_MESSAGE);
    }

    private static void validateNull(final String inputCarName) {
        if (isNull(inputCarName)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputCarName(String inputCarName) {
        validateNull(inputCarName);
        validateEndsWithComma(inputCarName);
    }

    private static void validateEndsWithComma(String inputCarName) {
        if (inputCarName.endsWith(CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException();
        }
    }

    private static Boolean isNull(final String input) {
        return input == null;
    }
}
