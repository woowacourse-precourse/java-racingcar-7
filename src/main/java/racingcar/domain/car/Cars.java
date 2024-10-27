package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        List<String> names = carNames.getCarNames();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return new Cars(cars);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        sortByDistanceHigh();
        Car winner = this.cars.getFirst();
        for (Car car : this.cars) {
            determineWinner(car, winner, winners);
        }

        return winners;
    }

    private void sortByDistanceHigh() {
        this.cars.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
    }

    private void determineWinner(Car car, Car winner, List<String> winners) {
        if (car.getDistance() == winner.getDistance()) {
            winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
