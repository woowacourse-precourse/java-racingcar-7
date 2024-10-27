package racingcar.view;

public class OutputMessage {

    private static final String HYPHEN = "-";

    public static void executeResultMessage(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public static void resultMessage() {
        System.out.println("\n실행결과");
    }

    public static void resultHyphenMessage(String carName, int carMoveCount) {
        System.out.println(carName + " : " + HYPHEN.repeat(carMoveCount));
    }
}
