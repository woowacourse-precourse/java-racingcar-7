package racingcar.repository;

import java.util.List;
import java.util.Optional;
import racingcar.entity.RacingCar;

public interface RacingCarRepository {
    void save(RacingCar racingCar);

    List<RacingCar> findAll();

    Optional<RacingCar> findByName(String name);
}
