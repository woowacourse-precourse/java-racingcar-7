package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputCar {

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));
        Validator.validateCarNames(names);

        return names;
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        Validator.validateTryCount(input);

        return Integer.parseInt(input);
    }
}
