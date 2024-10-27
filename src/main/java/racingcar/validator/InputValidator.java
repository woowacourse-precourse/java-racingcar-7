package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String charRegex = "^[ㄱ-ㅎ|가-힣|a-z|A-Z]*$";
    private static final String numRegex = "^[0-9]*$";

    // 자동차의 이름은 문자(영어 or 한글)로만 이루어져 있다고 가정
    public static void isStringOnly(String carNameListInput) {
        List<String> carNameList = Arrays.stream(carNameListInput.split(","))
                .collect(Collectors.toList());

        for(String carName : carNameList) {
            if (!Pattern.matches(charRegex, carName) || carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isNumberOnly(String input) {
        if (!Pattern.matches(numRegex, input)) {
            throw new IllegalArgumentException();
        }
    }
}
