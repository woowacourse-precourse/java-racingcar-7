package racingcar.constant;

public class Constant {

    // InputView
    public static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    // OutputView
    public static final String START_MESSAGE = "\n실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static final String RACE_PROGRESS_FORMAT = "%s : %s";
    public static final String RACE_PROGRESS_SYMBOL = "-";

    // Validator
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_CAR_COUNT = 2;
    public static final String SPACE = " ";
    public static final int MIN_ATTEMPT_COUNT = 1;

    // Parser
    public static final String CAR_NAME_SEPARATOR = ",";

    // RaceService
    public static final int MOVE_THRESHOLD = 4;
    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;

    // RaceController
    public static final String WINNER_NAME_JOINER = ", ";
}
