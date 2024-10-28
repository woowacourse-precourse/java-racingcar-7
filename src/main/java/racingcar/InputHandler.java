package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {
    public static List<String> getCarNames() {
        System.out.println(CAR_NAMES_INPUT);
        String input = Console.readLine();
        return InputParser.parseCarNames(input);
    }

    public static int getMaxRound() {
        System.out.println(MAX_ROUND_INPUT);
        String input = Console.readLine();
        return InputParser.parseMaxRound(input);
    }


    private static final String CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MAX_ROUND_INPUT = "시도할 횟수는 몇 회인가요?";
}
