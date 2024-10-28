package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    public List<String> inputCarName() {
        String input = Console.readLine();

        List<String> carList = Arrays.asList(input.split(","));

        return carList;
    }
}
