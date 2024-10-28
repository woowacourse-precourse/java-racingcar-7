package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private List<Car> cars;

    public CarRace() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void initialize(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void advanceCars(List<Boolean> isAdvance) {
        for (int i = 0; i < cars.size(); i++) {
            if (isAdvance.get(i)) {
                cars.get(i).addMove();
            }
        }
    }

    public List<Car> findWinners() {
        int max = findMax();
        return cars.stream()
                .filter(car -> car.getMove() == max)
                .collect(Collectors.toList());
    }

    private int findMax() {
        List<Integer> moves = pickMove();
        return moves.stream()
                .max(Integer::compareTo)
                .get();
    }

    private List<Integer> pickMove() {
        List<Integer> moves = new ArrayList<>();
        for (Car car : cars) {
            moves.add(car.getMove());
        }
        return moves;
    }
}
