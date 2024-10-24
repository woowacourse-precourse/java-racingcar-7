package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        InputValidator.validateCarNames(input);

        return parseCarNames(input);
    }

    private static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public static Integer getTotalRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        InputValidator.validateTotalRounds(input);

        return Integer.parseInt(input);
    }

}