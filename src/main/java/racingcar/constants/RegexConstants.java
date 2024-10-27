package racingcar.constants;

/**
 * 정규식 패턴 상수를 정의하는 클래스
 */
public class RegexConstants {

    public static final String COMMA = ",";
    public static final String COMMA_SPACE = ", ";
    public static final String COLON = ":";

    private static final String KOREAN_CHAR_RANGE = "가-힣";
    private static final String ALPHABET_RANGE = "a-zA-Z";
    private static final String DIGIT_RANGE = "0-9";

    /**
     * 자동차 이름은 한글, 알파벳, 숫자로 이루어질 수 있다.
     * 예: "ABC", "123", "가나다"
     */
    private static final String CAR_NAME_PATTERN = String.format("[%s%s%s]+", KOREAN_CHAR_RANGE, ALPHABET_RANGE, DIGIT_RANGE);

    /**
     * 자동차 이름은 쉼표(,)로 구분되며, 각 이름은 한글, 알파벳, 숫자 조합으로 이루어져야 한다.
     * 예: "가나다,ABC,123"
     */
    public static final String INPUT_CARS_PATTERN = String.format("^(%s(%s%s)*)$", CAR_NAME_PATTERN, COMMA, CAR_NAME_PATTERN);

    /**
     * 양의 정수를 나타내는 패턴. 반복 횟수 검증에 사용
     * 예: "1", "10", "123"
     */
    public static final String INTEGER_PATTERN = "^[1-9][0-9]*$";
}
