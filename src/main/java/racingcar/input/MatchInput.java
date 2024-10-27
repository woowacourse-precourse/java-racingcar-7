package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class MatchInput {
    protected static String input;

    private MatchInput(){}

    public static int getMatches() {
        System.out.println("1에서 1000 사이의 숫자를 입력해주세요: ");

        String input = Console.readLine();

        if (!input.matches("([1-9][0-9]{0,2}|1000)")) {
            throw new IllegalArgumentException("1~1000까지의 수만 입력하세요");
        }

        return Integer.parseInt(input);
    }
}
