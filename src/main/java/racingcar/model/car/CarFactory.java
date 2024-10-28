package racingcar.model.car;

public class CarFactory {
    public static Car createCar(
            String carNames,
            MoveStrategy moveStrategy
    ) {
        return new Car(carNames, moveStrategy);
    }
}
