package racingcar.endpoint;

public enum OutputInterface {
    ENTER_PLAYER_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ENTER_NUMBER_OF_TRIALS("시도할 횟수는 몇 회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    OutputInterface(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static void printMessage(String systemMessage) {
        System.out.println(systemMessage);
    }

    public static void printMessage(OutputInterface systemMessage) {
        System.out.println(systemMessage);
    }
}
