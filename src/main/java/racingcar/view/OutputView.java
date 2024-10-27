package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.Car;

public class OutputView {
    private static final String WINNER_FORMAT = "최종 우승자 : ";

    public void printRacing(Map<Car, Integer> situation) {
        System.out.println();
        System.out.println("실행 결과");
        for (Map.Entry<Car, Integer> entry : situation.entrySet()) {
            String distance = convertDistance(entry.getValue());
            System.out.println(entry.getKey() + " : " + distance);
        }
        System.out.println();
    }

    private String convertDistance(int value) {
        return "-".repeat(Math.max(0, value));
    }
}
