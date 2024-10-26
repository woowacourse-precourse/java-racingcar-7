package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> receiveCarNames() {
        System.out.println(Message.RECEIVE_CAR_NAMES);

        String input = getInput();

        return stringToList(input);
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static List<String> stringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .toList();
    }
}
