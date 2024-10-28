package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class MatchInput {
    protected static String input;

    private MatchInput(){}

    public static int getMatches() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();

        if (!input.matches("([1-9][0-9]{0,1}|100)")) {
            throw new IllegalArgumentException("1~100까지의 수만 입력하세요");
        }

        return Integer.parseInt(input);
    }
}
