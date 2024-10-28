package racingcar.message;

public class Message {
    public static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    public static final String GAME_ROUND_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?\n";
    public static final String EXECUTION_MESSAGE = "실행 결과\n";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static final String USER_INPUT_EMPTY_ERROR_MESSAGE = "No User Response found\n";

    public static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "Invalid car name length: length = 0\n";
    public static final String CAR_NAME_EXCEED_ERROR_MESSAGE = "Invalid car name length: length > 5\n";
    public static final String CAR_NAME_DUPLICATED_ERROR_MESSAGE = "Invalid car names: duplicated name\n";
    public static final String INVALID_GAME_ROUND_INT_ERROR_MESSAGE = "Invalid Game Round Input: value must be 1 or greater\n";
    public static final String INVALID_GAME_ROUND_VALUE_ERROR_MESSAGE = "Invalid Game Round Input: not integer\n";

}
