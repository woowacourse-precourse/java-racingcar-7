package racingcar;

public class IOMessage {
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    public static final String RACE_RESULT = "실행 결과";
    public static final String FINAL_WINNER = "최종 우승자";
    public static final String COLON_SEPARATOR = " : ";
    public static final String COMMA_SEPARATOR = ",";
    public static final String MOVEMENT_SIGN = "-";

    public static String buildRaceResult (String name, String movement) {
        return name + COLON_SEPARATOR + movement;
    }

    public static String buildFinalResult(String winner) {
        return FINAL_WINNER + COLON_SEPARATOR + winner;
    }

}
