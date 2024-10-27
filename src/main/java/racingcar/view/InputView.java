package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String ERROR_MESSAGE_FOR_NO_INPUT = "입력하지 않았습니다. 프로그램을 종료합니다.";

    public static String askCarName() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return validate(Console.readLine());
    }

    public static String askAttemptNumber() {
        System.out.println(ASK_ATTEMPT_NUMBER_MESSAGE);
        return validate(Console.readLine());
    }

    public static String validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NO_INPUT);
        }
        return input;
    }
}
