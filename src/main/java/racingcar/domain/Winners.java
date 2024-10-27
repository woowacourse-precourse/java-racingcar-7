package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public void add(Car car) {
        winners.add(car);
    }

    public Integer size() {
        return winners.size();
    }
}
