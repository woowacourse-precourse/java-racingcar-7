package racingcar.constants;

public class Constants {

    public static final String INPUT_CAR_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static final String EXECUTE_RESULT = "\n실행 결과";
    public static final String WINNER_RESULT = "최종 우승자 : ";

    public static final int NAME_MAX_LENGTH = 5;
//    public static final String CAR_LIST_PATTERN = "^([a-zA-Z0-9가-힣])(,[a-zA-Z0-9가-힣])*$";
    public static final String CAR_LIST_PATTERN = "^[a-zA-Z0-9가-힣]+[a-zA-Z0-9가-힣" + "," + "]*[a-zA-Z0-9가-힣]";

    public static final int GO_NUMBER = 4;

    public static final String DELIMITER = ",";
    public static final String DASH = "-";

    public static final String CAR_NAME_LENGTH_ERROR = "자동차 이름길이의 범위가 맞지 않습니다.";
    public static final String CAR_NAME_DUPLICATE_ERROR = "자동차 이름에 중복이 발생했습니다.";
    public static final String CAR_NAME_WRONG_ERROR = "자동차 이름 입력값이 잘못되었습니다.";
    public static final String ROUND_NUMBER_WRONG_ERROR = "시도 횟수는 1이상의 숫자여야 합니다.";
}
