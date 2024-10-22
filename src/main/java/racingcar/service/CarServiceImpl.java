package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.repository.CarRepository;

public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void register(String carName) {
        Car car = new Car(new CarName(carName));
        carRepository.save(car);
    }

}
