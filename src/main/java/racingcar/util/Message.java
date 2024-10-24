package racingcar.util;

public final class Message {

    public static final String INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    public static final String INPUT_TRIAL_COUNT = "시도할 횟수는 몇 회인가요?";

    public static final String OUTPUT_RACE_RESULT = "\n실행 결과";
    public static final String OUTPUT_WINNER = "최종 우승자";

    public static final String DELIMITER_POSITION_INCORRECT = "쉼표(,)의 위치가 잘못되었습니다.";
    public static final String NEED_MULTIPLE_RACING_CAR = "자동차 1대로는 자동차 경주를 진행할 수 없습니다.";
    public static final String NAME_LENGTH_NOT_VALID = "이름의 길이가 맞지 않습니다.";
    public static final String TRIAL_COUNT_NOT_POSITIVE = "숫자 뽑기 횟수가 양수가 아닙니다.";

    private Message() {
    }
}
