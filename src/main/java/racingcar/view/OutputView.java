package racingcar.view;

public class OutputView {
    private static final String STARTINGMESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNTINGMESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String MIDDLEPRINTMESSAGE = "실행 결과";

    public static void startingMessage() {
        System.out.println(STARTINGMESSAGE);
    }

    public static void insertCoinMessage() {
        System.out.println(COUNTINGMESSAGE);
    }

    public static void middlePrintMessage() {
        System.out.println();
        System.out.println(MIDDLEPRINTMESSAGE);
    }

    public static void middleResultMessage(String name, int count) {
        String location = "-".repeat(count);
        System.out.println(name + " : " + location);
    }

    public static void emptyLine() {
        System.out.println();
    }

}
