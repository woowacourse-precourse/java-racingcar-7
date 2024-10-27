package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
    protected static String input;

    private InputData() {
    }

    public static String getInput() {
        System.out.println("플레이어들을 쉼표로 구분해서 입력해주세요 : ");
        input = Console.readLine();
        return input;
    }
}
