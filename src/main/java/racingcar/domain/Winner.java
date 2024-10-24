package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final Cars cars;
    private final Race Race;
    private final List<Car> winners;
    public Winner(Cars cars, Race Race) {
        this.cars = cars;
        this.Race = Race;
        this.winners = new ArrayList<>();
    }

    public List<Car> getWinners() {
        for (Car car : cars.getCars()) {
            if (car.getPosition() == Race.getMaxPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
