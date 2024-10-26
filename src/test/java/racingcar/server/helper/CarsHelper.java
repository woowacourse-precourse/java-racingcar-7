package racingcar.server.helper;

import java.util.List;
import racingcar.server.model.car.Car;
import racingcar.server.model.car.Cars;

public class CarsHelper {

    public static Cars mocNoWinner() {

        List<Car> cars = List.of(
                CarHelper.mock("Java", 5, ""),
                CarHelper.mock("Rust", 5, ""),
                CarHelper.mock("Ruby", 5, "")
        );

        return Cars.of(cars);
    }

    public static Cars mockSingleWinner() {

        List<Car> cars = List.of(
                CarHelper.mock("Java", 4, "-"),
                CarHelper.mock("Rust", 2, "---"),
                CarHelper.mock("Ruby", 0, "-----")
        );

        return Cars.of(cars);
    }

    public static Cars mockMultiWinners() {

        List<Car> cars = List.of(
                CarHelper.mock("Java", 4, "-"),
                CarHelper.mock("Rust", 0, "-----"),
                CarHelper.mock("Ruby", 0, "-----")
        );

        return Cars.of(cars);
    }
}
