package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Reader {

    public static List<String> readCarNames() {
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        Console.close();

        return carNames;
    }

    public static int readNumber() {
        String input = Console.readLine();
        int number = Integer.parseInt(input);

        Console.close();

        return number;
    }
}
