package racingcar.global.io;

import java.util.Collections;
import java.util.List;
import racingcar.car.domain.Car;

public class OutputView {


    public static void printResult(List<Car> cars) {
        System.out.println("\n 실행 결과");
        for (Car car : cars) {
            System.out.printf("%s : %s\n\n",car.getName(),"-".repeat(car.getMove()));
        }
    }

    public static void printWinner(List<Car> cars) {
        List<String> results = cars.stream()
                .filter(c -> c.getMove() >= Collections.max(cars).getMove())
                .map(Car::getName)
                .toList();

        System.out.printf("최종 우승자 : %s ", String.join(", ", results) );

    }
}
