package racingcar.core.service;

import racingcar.converter.StringToRacingCarsConverter;
import racingcar.converter.StringToRacingTryCountConverter;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;
import racingcar.properties.RacingProperties;

import java.util.LinkedHashSet;
import java.util.List;

import static java.util.stream.IntStream.rangeClosed;

public class RacingService {

    private final StringToRacingCarsConverter racingCarsConverter;
    private final StringToRacingTryCountConverter tryCountConverter;

    private RacingProperties properties;

    public RacingService() {
        this.racingCarsConverter = new StringToRacingCarsConverter();
        this.tryCountConverter = new StringToRacingTryCountConverter();
    }

    public List<RacingCar> raceStartAndGetWinners(String cars, String tryCount) {
        Racing racing = createRacing(cars, tryCount);

        raceStart(racing);

        return racing.getWinners();
    }

    public RacingService properties(RacingProperties properties) {
        this.properties = properties;
        return this;
    }

    private void raceStart(Racing racing) {
        rangeClosed(1, racing.tryCount()).forEach(i -> race(racing.cars()));
    }

    private void race(LinkedHashSet<RacingCar> cars) {
        moveAllCars(cars);
        printCarsPostion(cars);
    }

    private Racing createRacing(String cars, String tryCount) {
        return Racing.of(racingCarsConverter.convert(cars), tryCountConverter.convert(tryCount));
    }

    private void moveAllCars(LinkedHashSet<RacingCar> cars) {
        cars.stream().filter(this::carNameFilter).forEach(this::moveCar);
    }

    private void moveCar(RacingCar car) {
        car.move(properties.getCarMoveNumberPicker().pick());
    }

    private boolean carNameFilter(RacingCar car) {
        return properties.getCarNameFilter().filter(car);
    }

    private void printCarsPostion(LinkedHashSet<RacingCar> cars) {
        properties.getCarPositionPrinter().print(cars);
    }
}
