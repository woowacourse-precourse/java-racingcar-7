package racingcar.helper;

import static racingcar.common.Constant.EMPYT_STRING;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class CarsHelper {

    public static Cars mocNoWinner() {

        List<Car> cars = List.of(
                CarHelper.mock("Java", 5, EMPYT_STRING),
                CarHelper.mock("Rust", 5, EMPYT_STRING),
                CarHelper.mock("Ruby", 5, EMPYT_STRING)
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
