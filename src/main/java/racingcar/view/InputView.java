package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT = "시도할 횟수는 몇 회인가요?";

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String input = Console.readLine();
        return input;
    }

    public static String inputAttempt() {
        System.out.println(INPUT_ATTEMPT);
        String input = Console.readLine();
        return input;
    }

}
