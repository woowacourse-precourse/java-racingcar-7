package racingcar.validate;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern ALPHABET_AND_COMMA_REGEX = Pattern.compile("[a-zA-Z,]+");
    private static final Pattern CONTINUOUS_COMMA_REGEX = Pattern.compile(",{2,}");

    public void noNull(final String inputCarNames) {
        if (inputCarNames == null) {
            throw new IllegalArgumentException("null 이 입력되서는 안됩니다.");
        }
    }

    public void noBlank(final String inputCarNames) {
        if (inputCarNames.isBlank()) {
            throw new IllegalArgumentException("빈 문자열, 공백이 입력되서는 안됩니다.");
        }
    }

    public void containsOnlyEnglishAndComma(final String inputCarNames) {
        if (!ALPHABET_AND_COMMA_REGEX.matcher(inputCarNames).matches()) {
            throw new IllegalArgumentException("영어(소문자, 대문자)와 쉼표(\",\") 만 입력할 수 있습니다.");
        }
    }

    public void noStartWithComma(final String inputCarNames) {
        if (inputCarNames.startsWith(",")) {
            throw new IllegalArgumentException("쉼표(\",\")로 시작해서는 안됩니다.");
        }
    }

    public void noEndWithComma(final String inputCarNames) {
        if (inputCarNames.endsWith(",")) {
            throw new IllegalArgumentException("쉼표(\",\")로 끝나서는 안됩니다.");
        }
    }

    public void hasNoContinuousComma(final String inputCarNames) {
        if (CONTINUOUS_COMMA_REGEX.matcher(inputCarNames).find()) {
            throw new IllegalArgumentException("쉼표(\",\"가 연속으로 입력되서는 안됩니다.");
        }
    }
}

