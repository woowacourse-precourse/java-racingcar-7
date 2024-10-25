package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingCarService implements CarService {

    private final CarRepository carRepository;

    public RacingCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void register(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car getCar(String name) {
        return carRepository.findByName(name);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
