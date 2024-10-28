package racingcar.utils.validator;

import racingcar.utils.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 자동차 이름 입력 문자열 형식을 검증함 */
public final class CarNamesValidator {

    public static final String ONLY_DIGIT_ALPHABET_KOREAN = "[0-9a-zA-Z가-힣]";

    public static final String MAX_CAR_NAME_LENGTH = "5";

    public static final String CAR_NAME_LENGTH_MIN_BETWEEN_MAX =
            "{1," + MAX_CAR_NAME_LENGTH + "}";

    public static final String CAR_NAME_DELIMITER = ",";

    // ^[0-9a-zA-Z가-힣]{1,5}(,[0-9a-zA-Z가-힣]{1,5})*$
    public static final String CAR_NAMES_FORMAT = "^" +
            ONLY_DIGIT_ALPHABET_KOREAN +
            CAR_NAME_LENGTH_MIN_BETWEEN_MAX +
            "(" + CAR_NAME_DELIMITER +
            ONLY_DIGIT_ALPHABET_KOREAN +
            CAR_NAME_LENGTH_MIN_BETWEEN_MAX +
            ")*$";

    // 자동차 이름 문자열 형식 검증 패턴
    public static final Pattern carNamePattern =
            Pattern.compile(CAR_NAMES_FORMAT);

    private CarNamesValidator() {}

    public static void whiteSpace(String names) {
        if (names.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.IN_SPACE.toString());
        }
    }

    public static void illegalLetter(String names) {
        Matcher matcher = carNamePattern.matcher(names);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_FORMAT.toString());
        }
    }

    public static void duplicateName(String names) {
        List<String> namesMayContainsDuplicate = List.of(names.split(","));
        Set<String> namesRemovedDuplicate = new HashSet<>(namesMayContainsDuplicate);
        if (namesMayContainsDuplicate.size() != namesRemovedDuplicate.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAMES.toString());
        }
    }

}
