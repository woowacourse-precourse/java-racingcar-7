package racingcar.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import racingcar.entity.RacingCar;

public class RacingCarRepositoryImpl implements RacingCarRepository {

    private static final HashSet<RacingCar> storage = new HashSet<>();

    @Override
    public void save(RacingCar racingCar) {
        storage.add(racingCar);
    }

    @Override
    public List<RacingCar> findAll() {

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.addAll(storage);

        return racingCars;
    }
}
