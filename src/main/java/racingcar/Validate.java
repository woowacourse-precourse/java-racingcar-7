package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validate {
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> carName(String inputCarName) {
        try {
            List<String> splitComma = checkComma(inputCarName);
            List<String> carNameList = checkLength(splitComma);
            List<String> finalCarNameList = checkCarNameList(carNameList);

            return finalCarNameList;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static List<String> checkCarNameList(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName == null || carName.trim().isEmpty()) {
                System.out.println(carNameList);
                throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
            }
        }
        return carNameList;
    }

    // 각 자동차 이름의 길이가 5자 이하인지 확인
    private static List<String> checkLength(List<String> splitComma) {
        for (String name : splitComma) {
            if (name.trim().length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
            }
        }
        return splitComma;
    }


    private static List<String> checkComma(String inputCarName) {
        List<String> splitCarName;

        if (inputCarName.contains(",")) {
            // TODO ,, 로 끝날경우?
            splitCarName = Arrays.asList(inputCarName.split(","));
            return splitCarName;
        }

        splitCarName = List.of(inputCarName);
        return splitCarName;
    }

    public static int attempts(String inputAttempts) {
        try {
            int resultAttempts = numberCheck(inputAttempts);
            return resultAttempts;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static int numberCheck(String inputAttempts) {
        try {
            int number = Integer.parseInt(inputAttempts);
            if (number <= 0) {
                throw new IllegalArgumentException("숫자는 양의 정수여야 합니다.");
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
    }
}
