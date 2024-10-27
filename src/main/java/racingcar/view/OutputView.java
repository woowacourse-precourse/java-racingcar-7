package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String POSITION_POINT = "-";

    public static void renderCars(Cars cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.name(), POSITION_POINT.repeat(car.position()));
        }
    }

    public static void renderWinner(Cars cars) {
        System.out.printf("최종 우승자 : %s\n", toWinnerFormat(winner(cars)));
    }

    private static List<Car> winner(Cars cars) {
        return cars.winner();
    }

    private static String toWinnerFormat(List<Car> winner) {
        return winner.stream().map(Car::name).collect(Collectors.joining(","));
    }
}
