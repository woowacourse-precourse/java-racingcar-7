package racingcar.helper;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.MyProgress;
import racingcar.model.position.Position;
import racingcar.model.race.Lap;

public class CarsHelper {

    public static Cars mockWithoutWinner() {
        Lap aRemaining = Lap.from(5);
        Lap bRemaining = Lap.from(5);
        Lap cRemaining = Lap.from(5);

        Position aPosition = Position.from("");
        Position bPosition = Position.from("--");
        Position cPosition = Position.from("---");

        MyProgress aProgress = MyProgress.from(aRemaining);
        MyProgress bProgress = MyProgress.from(bRemaining);
        MyProgress cProgress = MyProgress.from(cRemaining);

        ReflectionUtil.forceSetField(aProgress, "position", aPosition);
        ReflectionUtil.forceSetField(bProgress, "position", bPosition);
        ReflectionUtil.forceSetField(cProgress, "position", cPosition);

        Car aCar = Car.from("a", aProgress);
        Car bCar = Car.from("b", bProgress);
        Car cCar = Car.from("c", cProgress);

        return Cars.of(List.of(aCar, bCar, cCar));
    }

    public static Cars mockWithSingleWinner() {

        Lap aRemaining = Lap.from(4);
        Lap bRemaining = Lap.from(2);
        Lap cRemaining = Lap.from(0);

        Position aPosition = Position.from("");
        Position bPosition = Position.from("---");
        Position cPosition = Position.from("-----");

        MyProgress aProgress = MyProgress.from(aRemaining);
        MyProgress bProgress = MyProgress.from(bRemaining);
        MyProgress cProgress = MyProgress.from(cRemaining);

        ReflectionUtil.forceSetField(aProgress, "position", aPosition);
        ReflectionUtil.forceSetField(bProgress, "position", bPosition);
        ReflectionUtil.forceSetField(cProgress, "position", cPosition);

        List<Car> cars = List.of(
                Car.from("a", aProgress),
                Car.from("b", bProgress),
                Car.from("c", cProgress)
        );
        return Cars.of(cars);
    }

    public static Cars mockWithMultiWinner() {

        Lap aRemaining = Lap.from(4);
        Lap bRemaining = Lap.from(0);
        Lap cRemaining = Lap.from(0);

        Position aPosition = Position.from("");
        Position bPosition = Position.from("-----");
        Position cPosition = Position.from("-----");

        MyProgress aProgress = MyProgress.from(aRemaining);
        MyProgress bProgress = MyProgress.from(bRemaining);
        MyProgress cProgress = MyProgress.from(cRemaining);

        ReflectionUtil.forceSetField(aProgress, "position", aPosition);
        ReflectionUtil.forceSetField(bProgress, "position", bPosition);
        ReflectionUtil.forceSetField(cProgress, "position", cPosition);

        List<Car> cars = List.of(
                Car.from("a", aProgress),
                Car.from("b", bProgress),
                Car.from("c", cProgress)
        );
        return Cars.of(cars);
    }
}
