package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
    protected static String input;

    private InputData() {
    }

    public static String getInput() {
        System.out.println("플레이어들을 쉼표로 구분해서 입력해주세요 : ");

        input = Console.readLine();

        input = input.replaceAll("\\s", "");

        if (!input.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException("영어 알파벳과 쉼표만 입력하세요.");
        }

        return input;
    }
}
