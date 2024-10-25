package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
    private InputView() {}

    public static ArrayList<String> getCarNames() {
        ViewMessage.printInputNameMessage();
        return inputCarNames();
    }

    private static ArrayList<String> inputCarNames() {
        String nameInputString = Console.readLine();
        return makeStringToList(nameInputString);
    }

    private static ArrayList<String> makeStringToList(String nameInputString) {
        return new ArrayList<>(Arrays.asList(nameInputString.split(",")));
    }
}
