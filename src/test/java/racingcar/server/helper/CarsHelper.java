package racingcar.server.helper;

import java.util.List;
import racingcar.app.server.model.car.Car;
import racingcar.app.server.model.car.Cars;

public class CarsHelper {

    public static Cars mockNoWinner() {

        List<Car> cars = List.of(
                CarHelper.mock("Java", 5, 0),
                CarHelper.mock("Rust", 5, 0),
                CarHelper.mock("Ruby", 5, 0)
        );

        return Cars.of(cars);
    }

    public static Cars mockSingleWinner() {

        List<Car> cars = List.of(
                CarHelper.mock("Java", 4, 1),
                CarHelper.mock("Rust", 2, 3),
                CarHelper.mock("Ruby", 0, 5)
        );

        return Cars.of(cars);
    }

    public static Cars mockMultiWinners() {

        List<Car> cars = List.of(
                CarHelper.mock("Java", 4, 1),
                CarHelper.mock("Rust", 0, 5),
                CarHelper.mock("Ruby", 0, 5)
        );

        return Cars.of(cars);
    }
}
