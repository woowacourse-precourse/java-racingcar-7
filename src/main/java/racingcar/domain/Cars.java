package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator.move()));
    }

    public HashMap<String, Integer> getRoundResult() {
        HashMap<String, Integer> result = new HashMap<>();
        cars.forEach(car -> result.put(car.getName(), car.getPosition()));
        return result;
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            } else if (car.getPosition() > maxPosition) {
                winner.clear();
                maxPosition = car.getPosition();
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
