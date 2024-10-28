package racingcar.views;

import java.util.Map;

public class OutPutView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DISTANCE_SYMBOL = "-";

    public static void displayResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void displayCurrentCarsInfo(Map<String, Integer> carsInfo) {
        carsInfo.forEach((carName, distance) -> {
            System.out.println(formatCarInfo(carName, distance));
        });
        System.out.println();
    }

    private static String formatCarInfo(String carName, int distance) {
        return carName + " : " + DISTANCE_SYMBOL.repeat(distance);
    }

}