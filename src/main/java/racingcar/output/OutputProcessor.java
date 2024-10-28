package racingcar.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputProcessor {
    private static OutputProcessor instance;

    private OutputProcessor() {
    }

    public static OutputProcessor getInstance() {
        if (instance == null) {
            instance = new OutputProcessor();
        }

        return instance;
    }

    public void printRoundResult(List<Car> cars) {

        cars.forEach(car -> {
            String position = "-".repeat(Math.max(0, car.getPosition()));
            System.out.println(car.getName() + " : " + position);
        });

        System.out.println();
    }


    public void printGameResult(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "))
        );
    }
}
