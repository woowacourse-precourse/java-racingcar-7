package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.Util.Utils;
import racingcar.constants.NumberConstants;
import racingcar.constants.RegexConstants;

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

    public List<String> getOneRoundResult() {
        List<String> roundResult = new ArrayList<>();
        cars.forEach(car
                -> roundResult.add(car.getName()
                + " " + RegexConstants.COLON + " "
                + Utils.getTotalMoveDistance(car.getMoveDistance())));
        return roundResult;
    }

    public List<Car> getCars() {
        return cars;
    }
}
