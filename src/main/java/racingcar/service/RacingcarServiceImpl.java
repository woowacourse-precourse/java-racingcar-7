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

}
