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

    public RacingService() {
        this.racingCarsConverter = new StringToRacingCarsConverter();
        this.tryCountConverter = new StringToRacingTryCountConverter();
    }

    private RacingProperties properties;

    public List<RacingCar> raceStartAndGetWinners(String cars, String tryCount) {
        return raceStartAndGetWinners(createRacing(cars, tryCount));
    }

    private List<RacingCar> raceStartAndGetWinners(Racing racing) {
        rangeClosed(1, racing.tryCount())
                .mapToObj(i -> racing.cars())
                .peek(this::moveAll)
                .forEach(this::printCarsPostion);

        return racing.getWinners();
    }

    public RacingService properties(RacingProperties properties) {
        this.properties = properties;
        return this;
    }

    private Racing createRacing(String cars, String tryCount) {
        return Racing.of(racingCarsConverter.convert(cars), tryCountConverter.convert(tryCount));
    }

    private void moveAll(LinkedHashSet<RacingCar> cars) {
        cars.stream().filter(this::carNameFilter).forEach(this::move);
    }

    private void move(RacingCar car) {
        car.move(properties.getCarMoveNumberPicker().pickNumberValue());
    }

    private boolean carNameFilter(RacingCar car) {
        return properties.getCarNameFilter().filter(car);
    }

    private void printCarsPostion(LinkedHashSet<RacingCar> cars) {
        properties.getCarPositionPrinter().print(cars);
    }
}
