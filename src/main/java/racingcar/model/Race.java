package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;

    public Race(String[] carNames) {

        cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

    }

    public void proceedRace(int round) {

        while (round-- > 0) {
            for (Car car : cars) {
                car.moveForward();
            }
        }

    }

    public List<String> getWinners() {

        int maxPosition = cars.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition().length() == maxPosition) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

}
