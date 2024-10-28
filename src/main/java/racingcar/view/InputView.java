package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String INPUT_DELIMITER_COMMA = ",";
    private static final String INPUT_DUPLICATE_VALIDATE_MESSAGE = "ERROR: 중복된 값이 존재합니다.";
    private final ArrayList<String> inputDataList;
    String inputData;

    public InputView() {
        inputDataList = new ArrayList<>();
    }

    public String readInput() {
        inputData = Console.readLine();
        return inputData;
    }

    public void parserInputString(String readCarString) {
        if (readCarString != null && !readCarString.isEmpty()) {
            String[] parsedString = readCarString.split(INPUT_DELIMITER_COMMA);
            trimFirstElement(parsedString);
            validateNoDuplicates(parsedString);
            inputDataList.addAll(Arrays.asList(parsedString));
        }
    }

    private void trimFirstElement(String[] parsedString) {
        for (int i = 0; i < parsedString.length; i++) {
            parsedString[i] = parsedString[i].trim();
        }
    }

    public ArrayList<String> getParserInputString() {
        return inputDataList;
    }

    private void validateNoDuplicates(String[] elements) {
        Set<String> uniqueElements = new HashSet<>(Arrays.asList(elements));
        if (uniqueElements.size() != elements.length) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_VALIDATE_MESSAGE);
        }
    }
}
