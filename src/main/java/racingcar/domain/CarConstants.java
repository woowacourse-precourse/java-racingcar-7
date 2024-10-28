package racingcar.domain;

public class CarConstants {
    public static final String SEPARATOR = ",";
    public static final String SEPARATOR_NAME = "쉼표";
    public static final String VALID_INPUT_PATTERN = "^[a-zA-Z0-9\\s]+("+SEPARATOR+"[a-zA-Z0-9\\s]+)*$";
    // 알파벳 대소문자 또는 숫자로 이뤄진 문자열과 구분자(SEPARATOR)로 구성된 패턴
    public static final int CarNameLength = 5;

    public static final int tryNumRange = 100;
    public static final int fowardRange = 4;
}
