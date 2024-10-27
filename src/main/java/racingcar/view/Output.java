package racingcar.view;

import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class Output {
    private final static String DISTANCE_SIGN = "-";
    private final static String WINNER_DELIMITER = "," + " ";

    public static void printExecutionResultsMessage() {
        System.out.println("실행 결과");
    }

    public static void printIntermediateScore(Set<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            int distance = car.getDistance();
            String repeatedDashes = DISTANCE_SIGN.repeat(distance);

            System.out.printf("%s : %s\n", name, repeatedDashes);
        }
        System.out.println();
    }

    public static void printWinningCars(List<String> winningCars) {
        System.out.printf("최종 우승자 : %s",
                String.join(WINNER_DELIMITER, winningCars));
    }

}
