package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String GET_RACE_TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static String TURN_INPUT_TYPE_ERROR_MESSAGE = "숫자를 입력해 주세요.";

    public static String inputCarName() {
        System.out.println(GET_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static int inputRaceTurn() {
        System.out.println(GET_RACE_TURN_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(TURN_INPUT_TYPE_ERROR_MESSAGE);
        }
    }
}
