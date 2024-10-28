package racingcar.views;

import java.util.List;
import java.util.Map;

public class OutPutView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
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

    public static void displayWinner(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }

    private static String formatCarInfo(String carName, int distance) {
        return carName + " : " + DISTANCE_SYMBOL.repeat(distance);
    }

}