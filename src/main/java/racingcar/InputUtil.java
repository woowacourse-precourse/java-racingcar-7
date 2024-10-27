package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public static String inputNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = input();
        NumberInputValidator.validate(numberInput);
        return numberInput;
    }

    private static String input() {
        return Console.readLine();
    }
}
