package racingcar.domain;

import static racingcar.common.Constants.DELIMITER;

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

    public String getNames() {
        List<String> carNames = new ArrayList<>();

        for (Car car: winners) {
            carNames.add(car.getName());
        }

        return String.join(DELIMITER, carNames);

    }
}
