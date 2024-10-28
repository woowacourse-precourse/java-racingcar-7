package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class DataInput {
    protected static String input;

    private DataInput() {}

    public static String getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        input = Console.readLine();

        input = input.replaceAll("\\s", "");

        if (!input.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException("영어 알파벳과 쉼표만 입력하세요.");
        }

        return input;
    }
}
