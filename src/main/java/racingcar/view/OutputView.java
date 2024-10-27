package racingcar.view;

public class OutputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACE_RESULT_MESSAGE = "\n실행 결과";

    public static void printCarNamesMessage() {
        System.out.println(CAR_NAMES_MESSAGE);
    }

    public static void printRaceCountMessage() {
        System.out.println(RACE_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }
}
