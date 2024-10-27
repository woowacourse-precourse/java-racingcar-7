package racingcar.global.io;

import java.util.Collections;
import java.util.List;
import racingcar.car.domain.Car;

public class OutputView {

    public static void printResultHeader() {
        System.out.println("\n실행결과");
    }


    public static void printCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), generateMovement(car.getMove()));
        }
        System.out.println();
    }

    private static String generateMovement(int move) {
        return "-".repeat(move);
    }

    public static void printWinner(List<Car> cars) {
        int max = Collections.max(cars).getMove();
        List<String> results = getWinners(cars, max);

        System.out.printf("최종 우승자 : %s \n", String.join(", ", results));

    }

    private static List<String> getWinners(List<Car> cars, int max) {
        List<String> results = cars.stream()
                .filter(c -> c.getMove() >= max)
                .map(Car::getName)
                .toList();
        return results;
    }
}
