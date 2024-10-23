package racingcar.view;

import java.util.Set;
import racingcar.domain.Car;

public class Output {
    public static void printError(String error) {
        System.out.print("[ERROR] " + error);
    }

    public static void printIntermediateScore(Set<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            int distance = car.getDistance();
            String repeatedDashes = "-".repeat(distance);

            System.out.printf("%s : %s\n", name, repeatedDashes);
        }
        System.out.println();
    }

    public static void printExecutionResultsMessage() {
        System.out.println("실행 결과");
    }


}
