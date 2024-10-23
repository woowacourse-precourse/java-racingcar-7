package racingcar.utils;

public class Constant {

    // 입력 요구 메시지
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    // 에러 메시지
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";
    public static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "한 개 이상의 자동차 이름을 입력해야 합니다.";
    public static final String ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE = "시도할 횟수는 1 이상의 정수이어야 합니다.";

    // 자동차 이름 길이 최대값
    public static final int CAR_NAME_MAX_LENGTH_VALUE = 5;

    // 가능한 시도 횟수 최소값
    public static final int ATTEMPT_COUNT_MIN_VALUE = 1;

    // 양의 정수만 포함되어있는지 판별 정규식
    public static final String POSITIVE_INTEGER_REGEX = "[0-9]+";

    // 구분자
    public static final String DELIMITER = ",";

    // 자동차 객체 초기값
    public static final int CAR_SCORE_DEFAULT_VALUE = 0;

    // 무작위 값
    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;

    // 전진하기 위한 무작위 값의 임계값
    public static final int MOVE_THRESHOLD_VALUE = 4;

    // 출력 메시지
    public static final String GAME_RESULT_MESSAGE = "\n실행 결과";
    public static final String CAR_STATUS_MESSAGE = "%s : %s\n";
    public static final String GAME_WINNER_MESSAGE = "최종 우승자 : %s";
    public static final String MOVE_STRING = "-";

    private Constant() {}
}
