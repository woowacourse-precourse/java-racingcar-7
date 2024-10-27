package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.ForwardPolicy;

public class Game {

    private final Display display;
    private final List<Car> cars;
    private List<Car> winners;

    private Game(List<Car> cars, Display display) {
        this.cars = cars;
        this.display = display;
    }

    public void start(int reps, ForwardPolicy policy) {
        while (reps-- > 0) {
            cars.forEach(car -> car.forward(policy));
            display.progress(cars);
        }

        winners = determineWinnersIn(cars);
        display.winners(winners);
    }

    public List<Car> getWinners() {
        return winners;
    }

    private List<Car> determineWinnersIn(List<Car> cars) {
        int highestPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
            .filter(car -> car.getPosition() == highestPosition)
            .toList();
    }

    public static Game of(List<Car> cars, Display display) {
        return new Game(cars, display);
    }
}
