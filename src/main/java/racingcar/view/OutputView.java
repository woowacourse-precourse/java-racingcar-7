package racingcar.view;

public class OutputView {
    private static final String PRINT_READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_READ_TOTAL_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String PRINT_RACING_CAR_SUFFIX = " : ";

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printCarName(String CarName) {
        System.out.print(CarName + PRINT_RACING_CAR_SUFFIX);
    }

    public void printReadCarNameMessage() {
        printMessage(PRINT_READ_CAR_NAME_MESSAGE);
    }

    public void printReadTotalTryMessage() {
        printMessage(PRINT_READ_TOTAL_TRY_MESSAGE);
    }

}
