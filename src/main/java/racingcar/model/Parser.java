package racingcar.model;

import static racingcar.constant.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<String> parseCarNames(String carNamesInput) {
        String[] carNamesArray = splitBySeparator(carNamesInput, CAR_NAME_SEPARATOR);
        List<String> carNamesList = convertArrayToList(carNamesArray);
        return trimCarNames(carNamesList);
    }

    // TODO: 엄청 큰 숫자가 들어왔을 때도 고려
    public int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public String joinWithJoiner(List<String> list, String joiner) {
        return String.join(joiner, list);
    }

    private String[] splitBySeparator(String input, String separator) {
        return input.split(separator);
    }

    private List<String> convertArrayToList(String[] array) {
        return Arrays.asList(array);
    }

    private List<String> trimCarNames(List<String> carNames) {
        List<String> trimmedCarNames = new ArrayList<>();
        for (String carName : carNames) {
            trimmedCarNames.add(trimString(carName));
        }
        return trimmedCarNames;
    }

    private String trimString(String input) {
        return input.trim();
    }
}
