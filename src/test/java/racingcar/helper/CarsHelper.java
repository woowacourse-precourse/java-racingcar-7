package racingcar.helper;

import java.math.BigInteger;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.MyProgress;
import racingcar.model.race.Lap;
import racingcar.model.race.Position;

public class CarsHelper {
    public static Cars mockWithoutWinner() {
        Lap remaining = Lap.of(BigInteger.valueOf(4));

        Position aPosition = Position.initiate();
        ReflectionUtil.forceSetField(aPosition, "value", "");

        Position bPosition = Position.initiate();
        ReflectionUtil.forceSetField(bPosition, "value", "--");

        Position cPosition = Position.initiate();
        ReflectionUtil.forceSetField(cPosition, "value", "---");

        List<Car> cars = List.of(
                Car.of("a", MyProgress.initiate(remaining, aPosition)),
                Car.of("b", MyProgress.initiate(remaining, bPosition)),
                Car.of("c", MyProgress.initiate(remaining, cPosition))
        );
        return Cars.of(cars);
    }

    public static Cars mockWithSingleWinner() {

        Lap aRemaining = Lap.of(BigInteger.valueOf(4));
        Position aPosition = Position.initiate();
        ReflectionUtil.forceSetField(aPosition, "value", "");

        Lap bRemaining = Lap.of(BigInteger.valueOf(2));
        Position bPosition = Position.initiate();
        ReflectionUtil.forceSetField(bPosition, "value", "---");

        Lap cRemaining = Lap.of(BigInteger.valueOf(0));
        Position cPosition = Position.initiate();
        ReflectionUtil.forceSetField(cPosition, "value", "-----");

        List<Car> cars = List.of(
                Car.of("a", MyProgress.initiate(aRemaining, aPosition)),
                Car.of("b", MyProgress.initiate(bRemaining, bPosition)),
                Car.of("c", MyProgress.initiate(cRemaining, cPosition))
        );
        return Cars.of(cars);
    }

    public static Cars mockWithMultiWinner() {

        Lap aRemaining = Lap.of(BigInteger.valueOf(4));
        Position aPosition = Position.initiate();
        ReflectionUtil.forceSetField(aPosition, "value", "");

        Lap bRemaining = Lap.of(BigInteger.valueOf(0));
        Position bPosition = Position.initiate();
        ReflectionUtil.forceSetField(bPosition, "value", "-----");

        Lap cRemaining = Lap.of(BigInteger.valueOf(0));
        Position cPosition = Position.initiate();
        ReflectionUtil.forceSetField(cPosition, "value", "-----");

        List<Car> cars = List.of(
                Car.of("a", MyProgress.initiate(aRemaining, aPosition)),
                Car.of("b", MyProgress.initiate(bRemaining, bPosition)),
                Car.of("c", MyProgress.initiate(cRemaining, cPosition))
        );
        return Cars.of(cars);
    }
}
