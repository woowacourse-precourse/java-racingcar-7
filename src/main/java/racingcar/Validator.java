package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validateNotNumber(String tryCount) {
        String rex = "[^\\d]+";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(tryCount);

        if (matcher.find()) {
            throw new IllegalArgumentException("시도횟수는 양수만 입력할 수 있습니다.");
        }
    }

    public static void validateEmptyOrZeroTryCount(String inputString) {
        if (inputString.isBlank() || inputString.equals("0")) {
            throw new IllegalArgumentException("0또는 빈 값을 입력하셨습니다.");
        }
    }

    public static void validateNameLength(String inputname) {
        if (inputname.length() > 5) {
            throw new IllegalArgumentException("5글자 이하의 이름만 입력할 수 있습니다.");
        }
    }

    public static void validateNameFormat(String inputname) {
        String rex = "[\\W]+";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(inputname);

        if (matcher.find()) {
            throw new IllegalArgumentException("이름은 알파벳,숫자와 언더바(_)만 사용할 수 있습니다.");
        }
    }

    public static void validateEmptyString(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("빈값을 입력하셨습니다. 이름을 입력해주세요");
        }
    }
}
