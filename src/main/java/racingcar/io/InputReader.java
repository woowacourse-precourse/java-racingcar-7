package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    Validators validator = new Validators();

    public String readLine1() {
        String inputView = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(inputView);

        String input = Console.readLine();
        String validatedString = validator.validateString(input);

        return validatedString;
    }

    public int readLine2() {
        String inputView = "시도할 횟수는 몇 회인가요?";
        System.out.println(inputView);

        String input = Console.readLine();
        int validatedInteger = validator.validateInteger(input);

        return validatedInteger;
    }

    public void close() {
        Console.close();
    }
}
