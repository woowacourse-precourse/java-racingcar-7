package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.constants.NumberConstants;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public Race(final List<String> carNames, final NumberGenerator numberGenerator) {
        carNames.forEach(name -> cars.add(new Car(name)));
        this.numberGenerator = numberGenerator;
    }

    public void playOneRound() {
        for (Car car : cars) {
            if (numberGenerator.generateNumber() >= NumberConstants.MOVE_REQUIREMENT) {
                car.increaseDistance();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
