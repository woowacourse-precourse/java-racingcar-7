package racingcar.model.entity;

import racingcar.utils.ErrorMessage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 자동차 이름 입력값을 검증 기능 수행
 */
public class CarNames implements Iterable<String> {

    public static final String ONLY_DIGIT_ALPHABET_HANGEUL = "[0-9a-zA-Z가-힣]";

    public static final String MAX_CAR_NAME_LENGTH = "5";

    public static final String CAR_NAME_LENGTH_MIN_BETWEEN_MAX =
            "{1," + MAX_CAR_NAME_LENGTH + "}";

    public static final String CAR_NAME_DELIMITER = ",";

    // 자동차 이름 문자열 형식 검증 패턴
    public static final Pattern carNamePattern =
            Pattern.compile("^" +
                    ONLY_DIGIT_ALPHABET_HANGEUL +
                    CAR_NAME_LENGTH_MIN_BETWEEN_MAX +
                    "(" + CAR_NAME_DELIMITER +
                    ONLY_DIGIT_ALPHABET_HANGEUL +
                    CAR_NAME_LENGTH_MIN_BETWEEN_MAX +
                    ")*$");

    private final List<String> names;

    private CarNames(List<String> names) {
        this.names = names;
    }

    /**
     * 자동차 이름 문자열을 받아서 형식을 검증한 후 문자열로 반환하는 메서드
     * @param 검증되지 않은 자동차 이름 문자열
     * @return 자동차 이름 문자열(이름 사이에 쉼표(",")가 있는)
     * @throws 자동차 이름이 5글자 초과하거나 이름 중간에 알파벳, 한글, 숫자 이외의 문자가
     *         있으면 IllegalArgumentException 발생
     */
    public static CarNames getAfterValidateFormat(String namesToValidate) {
        Matcher matcher = carNamePattern.matcher(namesToValidate);
        validateSpace(namesToValidate);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_FORMAT.toString());
        }
        List<String> names = List.of(namesToValidate.split(","));
        validateDuplicate(names);
        return new CarNames(names);
    }

    private static void validateSpace(String namesToValidate) {
        if (namesToValidate.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.IN_SPACE.toString());
        }
    }

    private static void validateDuplicate(List<String> names) {
        Set<String> namesToCompare = new HashSet<>(names);
        if (names.size() != namesToCompare.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAMES.toString());
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new CarNamesIterator(this);
    }

    public int getLength() {
        return names.size();
    }

    public String getAt(int index) {
        return names.get(index);
    }

}
