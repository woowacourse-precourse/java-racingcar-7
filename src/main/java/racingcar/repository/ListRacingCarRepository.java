package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static racingcar.domain.Car.createCar;

public class ListRacingCarRepository implements RacingCarRepository {
    private static List<Car> cars;
    private static ListRacingCarRepository instance;

    public static ListRacingCarRepository getInstance() {
        if (instance == null) {
            instance = new ListRacingCarRepository();
        }
        return instance;
    }

    private ListRacingCarRepository() {
        cars = new ArrayList<>();
    }

    @Override
    public void addCarByName(String carName) {
        cars.add(createCar(carName));
    }

    @Override
    public Optional<Car> getCarByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}

