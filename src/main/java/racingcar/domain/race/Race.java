package racingcar.domain.race;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.acceleration.Acceleration;
import racingcar.domain.car.Car;
import racingcar.domain.race.vo.Round;

public class Race {

    private final static String COMMA = ",";
    private final static String NEW_LINE = "\n";
    private final static String DOUBLE_NEW_LINE = "\n\n";
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

    public String runRace(Round round) {
        StringBuilder result = new StringBuilder();

        while (round.hasMoreRounds()) {
            lap();
            round = round.nextRound();
            result.append(getRoundResult()).append(DOUBLE_NEW_LINE);
        }

        return result.toString();
    }

    public String getRoundResult() {
        return cars.stream()
            .map(Car::toString)
            .collect(Collectors.joining(NEW_LINE));
    }

    public void lap() {
        cars.forEach(Car::move);
    }
}