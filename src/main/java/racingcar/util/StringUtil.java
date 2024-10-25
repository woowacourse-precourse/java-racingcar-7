package racingcar.util;

public class StringUtil {

    private static final String REGEX = "(\\s*\\w+)(\\s*,\\s*\\w+\\s*)*";
    private static final String COMMA = ",";

    public static String[] getCarNames(String text) {
        validateMatchesRegex(text);
        return removeSpace(splitByDelimiter(text));
    }

    private static void validateMatchesRegex(String text) {
        if (isNotMatchesRegex(text)) {
            throw new IllegalArgumentException("자동차 이름은 콤마로 구분해야 합니다");
        }
    }

    private static boolean isNotMatchesRegex(String text) {
        return !text.matches(REGEX);
    }

    private static String[] splitByDelimiter(String text) {
        return text.split(COMMA);
    }

    private static String[] removeSpace(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].strip();
            validateNameLength(names[i]);
        }
        return names;
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 설정해야 합니다");
        }
    }
}
