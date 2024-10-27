package racingcar.domain.race;

import static racingcar.validation.CarNamesValidator.validateCarNames;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;
import racingcar.domain.car.Vehicle;
import racingcar.domain.strategy.RandomStrategy;
import racingcar.domain.strategy.Strategy;
import racingcar.validation.RaceCountValidator;

public class RaceManager {

    private static final String CAR_NAMES_SEPARATOR = ",";
    private static final Position INITIAL_POSITION = Position.from(0);
    private static final Strategy INITIAL_STRATEGY = RandomStrategy.from();

    private Cars cars;
    private int raceCount;

    public void setCars(String carNames) {
        validateCarNames(carNames);
        List<Vehicle> values = Arrays.stream(carNames.split(CAR_NAMES_SEPARATOR))
                .map(carName -> Car.of(Name.from(carName), INITIAL_POSITION, INITIAL_STRATEGY))
                .collect(Collectors.toList());
        this.cars = Cars.from(values);
    }

    public void setRaceCount(String raceCount) {
        RaceCountValidator.validateRaceCount(raceCount);
        this.raceCount = Integer.parseInt(raceCount);
    }

    public Cars playOnce() {
        List<Vehicle> values = cars.getValues().stream()
                .map(Vehicle::moveForwardRandomly)
                .collect(Collectors.toList());
        cars = Cars.from(values);
        return cars;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
