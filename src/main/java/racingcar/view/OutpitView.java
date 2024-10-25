package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutpitView {

    private static String RESULT = "실행 결과";
    private static String WINNER = "최종 우승자 : ";

    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printRacing(List<Map<String, Integer>> cars) {
        for (Map car : cars) {
            printCarPosition(car);
        }
    }

    private static void printCarPosition(Map<String, Integer> car) {
        car.forEach((name, position) ->
            System.out.println(name + " : " + "-".repeat(position)));
    }

    public static void printWinner(List<String> winners) {
        System.out.println(WINNER + String.join(",", winners));
    }
}
