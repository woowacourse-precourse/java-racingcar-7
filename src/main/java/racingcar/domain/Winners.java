package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class Winners {

    private static final String WINNER_TITLE = "최종 우승자 : ";
    private static final String COMMA_SEPARATOR = ", ";

    private final List<Name> winners;

    public Winners(Cars cars) {
        this.winners = findWinnerIn(cars);
    }

    private List<Name> findWinnerIn(Cars cars) {

        return cars.win().stream()
                .map(Car::getName)
                .toList();
    }

    @Override
    public String toString() {
        List<String> names = winners.stream()
                .map(Name::getName)
                .toList();

        return format(names);
    }

    private String format(List<String> names) {
        return WINNER_TITLE + String.join(COMMA_SEPARATOR, names);
    }
}
