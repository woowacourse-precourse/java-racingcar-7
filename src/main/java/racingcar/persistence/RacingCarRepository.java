package racingcar.persistence;

import java.util.List;
import racingcar.racing.RacingCar;

public interface RacingCarRepository {

    List<RacingCar> getAll();

    void addAll(List<RacingCar> racingCars);
}
