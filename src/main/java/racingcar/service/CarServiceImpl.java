package racingcar.service;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.repository.CarRepository;

public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void createCarsFromNameList(List<String> carNameList) {
        for (String carName : carNameList) {
            carRepository.save(new Car(carName));
        }

    }
}
