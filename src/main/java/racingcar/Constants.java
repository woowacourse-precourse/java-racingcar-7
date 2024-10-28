package racingcar;

public class Constants {
    //View
    public static final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PROMPT_ATTEMPTS = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_HEADER = "\n실행 결과";
    public static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    //InputParser
    public static final String CAR_NAME_DELIMITER = ",";

    public static final int MAX_CAR_NAME_COUNT = 100;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MAX_ASCII_CODE = 127;

    public static final String ERROR_NULL_INPUT = "입력값이 null이어서는 안 됩니다.";

    public static final String ERROR_EMPTY_NAME = "자동차 이름은 1자 이상이어야 합니다.";
    public static final String ERROR_TOO_MANY_CARS = "자동차 이름은 100개 이하로 입력되어야 합니다.";
    public static final String ERROR_NAME_TOO_LONG = "자동차 이름은 5자를 초과할 수 없습니다.";
    public static final String ERROR_NON_ASCII = "자동차 이름은 아스키 코드여야 합니다.";
    public static final String ERROR_BLANK_NAME = "자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.";
    public static final String ERROR_DUPLICATE_NAMES = "자동차 이름이 중복되어서는 안 됩니다.";

    public static final int MIN_ATTEMPT = 1;
    public static final int MAX_ATTEMPT = 100;

    public static final String ERROR_NOT_INTEGER_ATTEMPTS = "시도 횟수는 정수여야 합니다.";
    public static final String ERROR_NEGATIVE_OR_ZERO_ATTEMPTS = "시도 횟수는 양수여야 합니다.";
    public static final String ERROR_TOO_HIGH_ATTEMPTS = "시도 횟수는 100이하여야 합니다.";

    //GameLogic
    public static final int THRESHOLD = 4;
    public static final String MOVE_INDICATOR = "-";
}
