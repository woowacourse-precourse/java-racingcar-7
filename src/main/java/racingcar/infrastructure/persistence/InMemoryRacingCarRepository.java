package racingcar.infrastructure.persistence;

import racingcar.domain.car.RacingCar;
import racingcar.domain.car.repository.RacingCarRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRacingCarRepository implements RacingCarRepository {
    private static final InMemoryRacingCarRepository instance = new InMemoryRacingCarRepository();
    private final List<RacingCar> racingCars;

    private InMemoryRacingCarRepository() {
        this.racingCars = new ArrayList<>();
    }

    public static InMemoryRacingCarRepository getInstance(){
        return instance;
    }

    // TODO : RacingCar 저장
    public void saveRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    // TODO : RacingCar 반환
    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void clear() {
        racingCars.clear();
    }
}
