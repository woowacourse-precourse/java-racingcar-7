package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {}

    public static String inputCars() {
        final String INPUT_CARS_INTRO_MESSAGE ="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(INPUT_CARS_INTRO_MESSAGE);
        String input = Console.readLine();
        Console.close();
        return input;
    }
    public static String inputRounds() {
        final String INPUT_ROUNDS_INTRO_MESSAGE = "시도할 횟수는 몇 회인가요?";
        System.out.println(INPUT_ROUNDS_INTRO_MESSAGE);
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
