package racingcar.constant;

public class ViewConstants {
    public static final String NAME_DELIMITER = ",";
    public static final String FORWARD_SYMBOL = "-";
    public static final String POSITION_FORMAT = "%s : %s%n";
    public static final String WINNERS_DELIMITER = ", ";

    public static final String READ_NAMES_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String READ_ROUNDS_MESSAGE =
            "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_HEADER = "\n실행 결과";
    public static final String WINNERS_FORMAT = "최종 우승자 : %s";

    private ViewConstants() {
    }
}
