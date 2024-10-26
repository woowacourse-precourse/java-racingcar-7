package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class InputSplitter {
    public static List<String> inputSplit(String userInput) {
        String[] splitedInput = userInput.split(",");

        List<String> splitedInputList = new ArrayList<>(List.of(splitedInput));

        return splitedInputList;
    }
}
