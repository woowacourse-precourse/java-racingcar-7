package racingcar.constant;

public class Message {
    public static final String PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PROMPT_ROUND_COUNT = "시도할 회수는 몇회인가요?";
    public static final String EXECUTION_RESULT_HEADER = System.lineSeparator() + "실행 결과";
    public static final String FINAL_RESULT = "최종 우승자 : %s";
    public static final String CAR_NAME_DELIMITER = ",";
    public static final String RESULT_DISPLAY_FORMAT = "%s : %s";

    private Message() {
    }
}
