package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {
    private static int emptyCarNameCount = 1;

    public static List<String> parse(String input) {
        validateInput(input);
        return processInput(input);
    }

    private static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("경기에 진행할 자동차가 존재하지 않습니다");
        }
    }

    private static List<String> processInput(String input) {
        List<String> carList = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(CarNameParser::processCarName)
                .toList();
        return carList;
    }

    private static String processCarName(String carName) {
        validateCarName(carName);
        carName = replaceEmptyCarName(carName);

        return carName;
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다: " + carName);
        }
    }

    private static String replaceEmptyCarName(String carName) {
        if (carName.isBlank()) {
            return "무명" + emptyCarNameCount++;
        }
        return carName;
    }

}
