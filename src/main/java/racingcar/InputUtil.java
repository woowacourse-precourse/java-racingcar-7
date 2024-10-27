package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public static String inputNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = input();
        NumberInputValidator.validate(numberInput);
        return numberInput;
    }

    public static String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = input();
        NamesInputValidator.validate(namesInput);
        return namesInput;
    }

    private static String input() {
        return Console.readLine();
    }
}
