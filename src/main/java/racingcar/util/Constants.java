package racingcar.util;

/**
 * Constants 클래스는 경주 게임에서 공통적으로 사용하는 상수와 예외 메시지를 정의하여
 * 여러 클래스에서 일관되게 사용할 수 있도록 한다.
 */
public class Constants {

    // 예외 메시지
    public static final String EMPTY_CAR_NAMES_ERROR = "자동차 이름 입력이 비어있습니다.";
    public static final String DUPLICATE_CAR_NAME_ERROR = "중복된 자동차 이름이 존재합니다: ";
    public static final String EMPTY_NAME_ERROR = "자동차 이름이 공백일 수 없습니다.";
    public static final String CAR_NAME_LENGTH_ERROR = "자동차 이름은 5자 이하로 입력해주세요: ";
    public static final String EMPTY_TRIAL_ERROR = "시도 횟수가 입력되지 않았습니다.";
    public static final String NON_NUMERIC_TRIAL_ERROR = "유효한 숫자가 아닙니다.";
    public static final String INVALID_TRIAL_ERROR = "시도 횟수는 0보다 커야 합니다.";

    // 기타 상수
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int DEFAULT_CAR_START_POSITION = 0;
    public static final String DEFAULT_REPEATER = "-";
}