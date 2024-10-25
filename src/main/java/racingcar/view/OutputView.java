package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    private final static String RESULT_MESSAGE = "실행 결과";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void lineSeparator() {
        System.out.println();
    }

    public static void printGameStartMessage() {
        printMessage(RESULT_MESSAGE);
    }

    public static void printCarStatus(Car car) {
        printMessage(car.toString());
    }

    public static void printWinner(String winner) {
        printMessage("최종 우승자 : " + winner);
    }

}
