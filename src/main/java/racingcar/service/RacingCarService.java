package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.repository.RacingCarRepository;

import java.util.Collection;

public class RacingCarService {

    private final RacingCarRepository racingCarRepository;

    public RacingCarService(RacingCarRepository racingCarRepository){
        this.racingCarRepository = racingCarRepository;
    }

    public void registerRacingCars(Collection<String> carNames){
        carNames.forEach(carName -> racingCarRepository.save(RacingCar.createRacingCar(carName)));
    }
}
