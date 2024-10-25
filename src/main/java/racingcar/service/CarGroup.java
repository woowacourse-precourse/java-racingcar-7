package racingcar.service;

import java.util.List;
import racingcar.context.Car;
import racingcar.strategy.MovementStrategy;

public class CarGroup {

    private final List<Car> carGroup;

    public CarGroup(List<String> carNameGroup) {
        this.carGroup = createCarNameToRacingCar(carNameGroup);
    }

    private List<Car> createCarNameToRacingCar(List<String> carNameGroup) {
        return carNameGroup
                .stream()
                .map(x -> new Car(x.trim(), new MovementStrategy()))
                .toList();
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }
}
