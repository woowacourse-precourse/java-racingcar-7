package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class WinnerService {
    CarRepository carRepository;

    public WinnerService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();

        List<Car> carsResult = carRepository.findAll();
        List<Car> winners = carsResult.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();

        return winners;
    }

    private int getMaxDistance() {
        List<Car> carsResult = carRepository.findAll();

        int maxDistance = carsResult.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(0);

        return maxDistance;
    }
}
