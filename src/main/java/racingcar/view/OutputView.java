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

}
