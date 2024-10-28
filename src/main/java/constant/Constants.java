package constant;

public final class Constants {

    public static final String CONTENT_DELIMITER = ",";

    //InputManager
    public static final String RACING_CAR_INPUT_MASSEAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACING_TURN_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    //OutputManager
    public static final String RACING_START_MESSAGE = "실행 결과";
    public static final String RACING_WINNER_MESSAGE = "최종 우승자 : ";

    //Validator
    public static final int RACING_CAR_NAME_LIMIT = 5;

    //PlayerMoving
    public static final int RACING_RANDOM_NUMBER_MINIMUM = 0;
    public static final int RACING_RANDOM_NUMBER_MAXIMUM = 9;
    public static final int MOVING_CRITERIA = 4;

    //생성자를 private로 선언함으로써 인스턴스를 생성할 수 없게 막음
    private Constants(){

    }
}
