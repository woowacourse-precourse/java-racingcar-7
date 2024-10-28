package racingcar.getWinners;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.race.Race;

public class GetWinners {
    private Race race;
    private List<Car> cars;

    public GetWinners(Race race) {
        this.race = race;
        this.cars = new ArrayList<>(race.getCars());
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.toString().split(" : ")[0])
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
