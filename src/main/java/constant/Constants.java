package constant;

public final class Constants {

    /** CONTENT_DELIMITER : 입출력에 사용하느 구분자 상수입니다.
     * 입력의 경우 : 구분자를 통해 문자얄을 ArrayList로 분리할 때 사용
     * 출력의 경우 : 결과를 출력할 때 원소들 사이를 구분하는 용도로 사용*/
    public static final String CONTENT_DELIMITER = ",";

    /** Inputmanager 상수
     *  RACING_CAR_NAME_INPUT_MESSAGE : 자동차 이름을 모은 문자열을 받기 전에 출력해야하는 문구입니다.
     *  RICING_CAR_TURN_INPUT_MESSAGE : 레이싱의 힛수를 입력 받기 전에 출력해야하는 문구입니다.
     */
    public static final String RACING_CAR_NAME_INPUT_MASSEAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACING_TURN_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    /**OutputManager 상수
     * RACING_START_MESSAGE : 레이스가 시작됐을 때 출력해야하는 문구입니다.
     * RACING_WINNER_MESSAGE : 승자 분석이 끝나고 난 뒤에 결과를 출력할 때 앞에 나와야하는 문구입니다. 
     * 이 문구는 사용 후에 줄바꿈이 있으면 안됩니다.
     */
    public static final String RACING_START_MESSAGE = "실행 결과";
    public static final String RACING_WINNER_MESSAGE = "최종 우승자 : ";

    /**Validator
     * RACING_CAR_NAME_LIMIT : 자동차의 길이 제한입니다. 글자 수가 설정된 값보다 클 수 없으며, 그럴 때는 예외처리를 해주셔아합니다.
     */
    public static final int RACING_CAR_NAME_LIMIT = 5;

    /**PlayerMoving
     *  RACING_RANDOM_NUMBER_MINIMUM, RACING_RANDOM_NUMBER_MAXIMUM : 자동으로 생성되는 수의 하한선과 상한선입니다.
     *  [RACING_RANDOM_NUMBER_MINIMUM:RACING_RANDOM_NUMBER_MAXIMUM] 의 범위의 수가 뽑힙니다
     *  MOVING_CRITERIA : 설정된 값 이상의 수가 randomNumberGenerator에서 나올 때 자동차를 움직입니다.
     */
    public static final int RACING_RANDOM_NUMBER_MINIMUM = 0;
    public static final int RACING_RANDOM_NUMBER_MAXIMUM = 9;
    public static final int MOVING_CRITERIA = 4;

    //생성자를 private로 선언함으로써 인스턴스를 생성할 수 없게 막음
    private Constants(){

    }
}
