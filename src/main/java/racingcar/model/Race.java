package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.constants.NumberConstants;
import racingcar.constants.RegexConstants;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public Race(final List<String> carNames, final NumberGenerator numberGenerator) {
        carNames.forEach(name -> cars.add(new Car(name)));
        this.numberGenerator = numberGenerator;
    }

    public void playSingleRound() {
        for (Car car : cars) {
            if (numberGenerator.generateNumber() >= NumberConstants.MOVE_REQUIREMENT) {
                car.increaseDistance();
            }
        }
    }

    public List<String> getSingleRoundResult() {
        List<String> roundResult = new ArrayList<>();
        cars.forEach(car
                -> roundResult.add(car.getName()
                + " " + RegexConstants.COLON + " "
                + getTotalMoveDistance(car.getMoveDistance())));
        return roundResult;
    }

    private StringBuilder getTotalMoveDistance(int moveDistance) {
        StringBuilder total = new StringBuilder();
        IntStream.range(0, moveDistance).forEach(i -> total.append("-"));
        return total;
    }

    public List<Car> getCars() {
        return cars;
    }
}
