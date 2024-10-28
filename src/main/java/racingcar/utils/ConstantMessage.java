package racingcar.utils;

public class ConstantMessage {
    private ConstantMessage() {
    }

    static public final String COMMA_SEPARATOR = ", ";
    static public final String DISTANCE_MARKER = "-";

    static public final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static public final String INPUT_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";
    static public final String OUTPUT_RESULT_MESSAGE = "실행 결과";
    static public final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";

    static public final String NAME_LENGTH_EXCEPTION = "name is too long.";
    static public final String INVALID_RANGE_EXCEPTION = "Invalid boundary value."; // 예외가 발생할 일이 없지만 확장성을 위해 남겨둠.
    static public final String DUPLICATED_NAME_EXCEPTION = "Duplicated name exist.";
}
