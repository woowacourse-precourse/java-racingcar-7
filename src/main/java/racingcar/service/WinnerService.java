package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class WinnerService {
    private final CarRepository carRepository;

    public WinnerService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getWinners() {
        List<Car> carsResult = carRepository.findAll();

        int maxDistance = getMaxDistance(carsResult);
        List<Car> winners = carsResult.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();

        return winners;
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
