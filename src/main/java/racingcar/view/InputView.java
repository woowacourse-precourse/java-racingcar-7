package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
    private static final String INPUT_DELIMITER_COMMA = ",";
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

            for (String carName : parsedString) {
                String trimmedCarName = carName.trim();
                checkDuplicateAndAddCarName(trimmedCarName);
            }
        }
    }

    private void checkDuplicateAndAddCarName(String carName) {
        if (inputDataList.contains(carName)) {
            throw new IllegalArgumentException("Error: 중복된 이름이 존재합니다.");
        }
        inputDataList.add(carName);
    }

    private void trimFirstElement(String[] parsedString) {
        for (int i = 0; i < parsedString.length; i++) {
            parsedString[i] = parsedString[i].trim();
        }
    }

    public ArrayList<String> getParserInputString() {
        return inputDataList;
    }

}
