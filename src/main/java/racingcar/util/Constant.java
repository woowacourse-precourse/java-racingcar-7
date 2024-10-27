package racingcar.util;

public class Constant {
    // 구분자
    public static final String NAME_SEPARATOR = ",";

    // 에러 메시지
    public static final String NAME_INPUT_LENGTH_ERROR = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String NAME_NO_INPUT_ERROR = "자동차 이름은 빈 칸일 수 없습니다.";
    public static final String NAME_INPUT_BLANK_ERROR = "자동차 이름에 공백이 포함되어있습니다. 공백없이 입력해주세요.";
    public static final String NAME_INPUT_INVALID_COMMA = "자동자 이름에 유효하지않은 쉼표가 입력되었습니다.";
    public static final String ATTEMPT_INPUT_ERROR_MESSAGE = "시도 횟수는 공백없는 정수만 입력 가능합니다.";
    public static final String NAME_INPUT_DUPLICATE_ERROR = "자동차 이름이 중복되었습니다.";

    // 제한값
    public static final int CAR_NAME_LENGTH_LIMIT = 5;
    public static final int MIN_RANDOM = 0;
    public static final int MAX_RANDOM = 9;
    public static final int STANDARD_FOR_MOVING = 4;

    // 메시지
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String PRINT_RESULT_MESSAGE = "\n실행 결과";
    public static final String PRINT_WINNER = "최종 우승자 : ";
}
