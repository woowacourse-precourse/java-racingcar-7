package racingcar.view;

public class OutputView {
    public static final String REQUEST_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_FOR_RACE_COUNT = "시도할 횟수는 몇 회인가요?";

    private OutputView() {}

    public static void requestForCarNames() {
        OutputWriter.displayMessage(REQUEST_FOR_CAR_NAMES);
    } // requestForCarNames

    public static void requestForRaceCount() {
        OutputWriter.displayMessage(REQUEST_FOR_RACE_COUNT);
    } // requestForRaceCount
} // class