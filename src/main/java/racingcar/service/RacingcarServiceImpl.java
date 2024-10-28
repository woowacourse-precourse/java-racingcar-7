package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.RacingcarRepository;
import racingcar.validator.CarNameValidator;

public class RacingcarServiceImpl implements RacingcarService {
    private final RacingcarRepository racingcarRepository;

    public RacingcarServiceImpl(RacingcarRepository racingcarRepository) {
        this.racingcarRepository = racingcarRepository;
    }

    @Override
    public void initializeCars(String name) {
        var playerArray = name.split(",");
        var players = List.of(playerArray);

        for (var carName : players) {
            CarNameValidator.validate(carName);
            Car car = new Car(carName);
            racingcarRepository.save(car);
        }
    }

    @Override
    public void moveCars() {
        List<Car> cars = racingcarRepository.getAllCar();

        for (var car : cars) {
            car.move();
        }
    }

    @Override
    public String getRoundStatus() {
        List<Car> cars = racingcarRepository.getAllCar();

        var sb = new StringBuilder();
        for (var car : cars) {
            sb.append(car.getState())
                    .append("\n");
        }

        return sb.toString();
    }
}
