package racingcar.helper;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.MyProgress;
import racingcar.model.race.Lap;
import racingcar.model.race.Position;

public class CarsHelper {
    public static Cars mockInitial() {
        Lap aRemaining = Lap.of("5");
        Lap bRemaining = Lap.of("5");
        Lap cRemaining = Lap.of("5");

        Position aPosition = Position.initiate();
        ReflectionUtil.forceSetField(aPosition, "value", "");

        Position bPosition = Position.initiate();
        ReflectionUtil.forceSetField(bPosition, "value", "");

        Position cPosition = Position.initiate();
        ReflectionUtil.forceSetField(cPosition, "value", "");

        List<Car> cars = List.of(
                Car.from("a", MyProgress.from(aRemaining, aPosition)),
                Car.from("b", MyProgress.from(bRemaining, bPosition)),
                Car.from("c", MyProgress.from(cRemaining, cPosition))
        );
        return Cars.of(cars);
    }

    public static Cars mockWithoutWinner() {
        Lap remaining = Lap.of("4");

        Position aPosition = Position.initiate();
        ReflectionUtil.forceSetField(aPosition, "value", "");

        Position bPosition = Position.initiate();
        ReflectionUtil.forceSetField(bPosition, "value", "--");

        Position cPosition = Position.initiate();
        ReflectionUtil.forceSetField(cPosition, "value", "---");

        List<Car> cars = List.of(
                Car.from("a", MyProgress.from(remaining, aPosition)),
                Car.from("b", MyProgress.from(remaining, bPosition)),
                Car.from("c", MyProgress.from(remaining, cPosition))
        );
        return Cars.of(cars);
    }

    public static Cars mockWithSingleWinner() {

        Lap aRemaining = Lap.of("4");
        Position aPosition = Position.initiate();
        ReflectionUtil.forceSetField(aPosition, "value", "");

        Lap bRemaining = Lap.of("2");
        Position bPosition = Position.initiate();
        ReflectionUtil.forceSetField(bPosition, "value", "---");

        Lap cRemaining = Lap.of("0");
        Position cPosition = Position.initiate();
        ReflectionUtil.forceSetField(cPosition, "value", "-----");

        List<Car> cars = List.of(
                Car.from("a", MyProgress.from(aRemaining, aPosition)),
                Car.from("b", MyProgress.from(bRemaining, bPosition)),
                Car.from("c", MyProgress.from(cRemaining, cPosition))
        );
        return Cars.of(cars);
    }

    public static Cars mockWithMultiWinner() {

        Lap aRemaining = Lap.of("4");
        Position aPosition = Position.initiate();
        ReflectionUtil.forceSetField(aPosition, "value", "");

        Lap bRemaining = Lap.of("0");
        Position bPosition = Position.initiate();
        ReflectionUtil.forceSetField(bPosition, "value", "-----");

        Lap cRemaining = Lap.of("0");
        Position cPosition = Position.initiate();
        ReflectionUtil.forceSetField(cPosition, "value", "-----");

        List<Car> cars = List.of(
                Car.from("a", MyProgress.from(aRemaining, aPosition)),
                Car.from("b", MyProgress.from(bRemaining, bPosition)),
                Car.from("c", MyProgress.from(cRemaining, cPosition))
        );
        return Cars.of(cars);
    }
}
