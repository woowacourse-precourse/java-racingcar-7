package racingcar.application.service;

import java.util.List;
import racingcar.persistence.InMemoryRacingCarRepository;
import racingcar.racing.RacingCar;
import racingcar.application.RacingManager;

public class RacingCarManager implements RacingManager<RacingCar> {

    private final InMemoryRacingCarRepository inMemoryRacingCarRepository;

    public RacingCarManager(InMemoryRacingCarRepository inMemoryRacingCarRepository) {
        this.inMemoryRacingCarRepository = inMemoryRacingCarRepository;
    }

    @Override
    public void registerAll(List<RacingCar> racers) {
        inMemoryRacingCarRepository.addAll(racers);
    }
}
