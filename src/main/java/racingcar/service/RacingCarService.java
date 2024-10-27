package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.RacingCarRepository;

public class RacingCarService implements CarService {

    private final RacingCarRepository carRepository = RacingCarRepository.getInstance();

    private static final RacingCarService instance = new RacingCarService();

    public static RacingCarService getInstance() {
        return instance;
    }

    private RacingCarService() {
    }

    @Override
    public void register(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
