package racingcar.infrastructure.persistence;

import racingcar.domain.car.RacingCar;
import racingcar.domain.car.repository.RacingCarRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRacingCarRepository implements RacingCarRepository {
    private final List<RacingCar> racingCars;

    public InMemoryRacingCarRepository() {
        this.racingCars = new ArrayList<>();
    }

    // TODO : RacingCar 저장
    public void saveRacingCar(RacingCar racingCar) {

    }

    // TODO : RacingCar 반환
    public List<RacingCar> getRacingCars() {
        return null;
    }
}
