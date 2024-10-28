package racingcar.domain.race;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.acceleration.Acceleration;
import racingcar.domain.car.Car;
import racingcar.domain.race.vo.RaceResult;
import racingcar.domain.race.vo.Round;
import racingcar.domain.race.vo.RoundResult;
import racingcar.domain.race.vo.RoundResults;

public class Race {

    private final static String COMMA = ",";
    private List<Car> cars;

    private Race(final List<Car> cars) {
        this.cars = cars;
    }

    public static Race of(final String input, final Acceleration acceleration) {
        List<Car> cars = Arrays.stream(input.split(COMMA))
            .map(name -> new Car(name.trim(), acceleration))
            .collect(Collectors.toUnmodifiableList());

        return new Race(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public RaceResult runRace(Round round) {
        RaceResult raceResult = new RaceResult();

        while (round.hasMoreRounds()) {
            lap();
            round = round.nextRound();
            raceResult.addRound(getRoundResults());
        }

        return raceResult;
    }

    private void lap() {
        cars.forEach(Car::move);
    }

    private RoundResults getRoundResults() {
        return new RoundResults(
            cars.stream()
	.map(car -> new RoundResult(car.getName(), car.getPosition()))
	.collect(Collectors.toList())
        );
    }
}