package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinnerCars {
    private final List<Car> winners;

    public WinnerCars() {
        this(new ArrayList<>());
    }

    public WinnerCars(List<Car> winners) {
        this.winners = winners;
    }

    public void addWinner(Car car, int maxDistance) {
        if (car.isSameDistance(maxDistance)) {
            this.winners.add(car);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerCars winnerCars = (WinnerCars) o;
        return Objects.equals(this.winners, winnerCars.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
