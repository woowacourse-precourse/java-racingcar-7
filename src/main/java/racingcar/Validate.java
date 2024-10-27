package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validate {
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> carName(String inputCarName) {
        List<String> splitComma = checkComma(inputCarName);
        List<String> carNameList = checkLength(splitComma);
        List<String> finalCarNameList = checkCarNameList(carNameList);

        return finalCarNameList;
    }

    static List<String> checkCarNameList(List<String> carNameList) {
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


    static List<String> checkComma(String inputCarName) {
        Pattern startCommaOrEndComma = Pattern.compile("^,|,$");
        List<String> splitCarName;

        if (startCommaOrEndComma.matcher(inputCarName).find()) {
            throw new IllegalArgumentException("자동차 이름의 시작이나 끝에 콤마가 올 수 없습니다.");
        }

        if (inputCarName.contains(",")) {
            splitCarName = Arrays.asList(inputCarName.split(","));
            
            return splitCarName;
        }

        splitCarName = List.of(inputCarName);

        return splitCarName;
    }

    public static int attempts(String inputAttempts) {
        int resultAttempts = numberCheck(inputAttempts);
        return resultAttempts;
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
