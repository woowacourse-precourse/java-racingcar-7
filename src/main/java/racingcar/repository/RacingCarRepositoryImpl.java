package racingcar.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import racingcar.entity.RacingCar;

public class RacingCarRepositoryImpl implements RacingCarRepository {

    private static List<RacingCar> storage = new ArrayList<>();

    @Override
    public void save(RacingCar racingCar) {
        storage.add(racingCar);
    }

    @Override
    public List<RacingCar> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Optional<RacingCar> findByName(String name) {
        return storage.stream()
                .filter(racingCar -> racingCar.getName().equals(name))
                .findFirst();
    }

    @Override
    public void deleteAll() {
        storage = new ArrayList<>();
    }
}
