package racingcar.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<RacingCar> findByName(String name) {

        Optional<RacingCar> oRacingCar = Optional.empty();

        for (RacingCar racingCar : storage) {
            if (racingCar.getName().equals(name)) {
                oRacingCar = Optional.of(racingCar);
                break;
            }
        }

        return oRacingCar;
    }
}
