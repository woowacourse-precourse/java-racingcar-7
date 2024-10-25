package racingcar.service;

import java.util.List;
import racingcar.context.Car;
import racingcar.strategy.MovementStrategy;

public class CreateCarGroup {

    private final List<Car> carGroup;

    public CreateCarGroup(List<String> carNameGroup) {
        this.carGroup = changeCarNameToRacingCar(carNameGroup);
    }

    private List<Car> changeCarNameToRacingCar(List<String> carNameGroup) {
        return carNameGroup
                .stream()
                .map(x -> new Car(x.trim(), new MovementStrategy()))
                .toList();
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }
}
