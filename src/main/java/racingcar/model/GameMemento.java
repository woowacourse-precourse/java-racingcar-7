package racingcar.model;

import java.util.List;

public class GameMemento {
    private final List<Car> carStates;

    public GameMemento(List<Car> carStates) {
        this.carStates = carStates;
    }

    public List<Car> getCarStates() {
        return carStates;
    }
}
