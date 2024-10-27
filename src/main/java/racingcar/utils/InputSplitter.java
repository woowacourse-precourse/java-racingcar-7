package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class InputSplitter {
    public static String SPLIT_REGEX = ",";

    public static List<String> inputSplit(String userInput) {
        String[] splitedInput = userInput.split(SPLIT_REGEX);

        List<String> splitedInputList = new ArrayList<>(List.of(splitedInput));

        return splitedInputList;
    }
}
