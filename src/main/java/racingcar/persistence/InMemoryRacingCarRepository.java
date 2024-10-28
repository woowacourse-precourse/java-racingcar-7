package racingcar.persistence;

import java.util.ArrayList;
import java.util.List;
import racingcar.racing.RacingCar;

public class InMemoryRacingCarRepository implements RacingCarRepository{

    private static final InMemoryRacingCarRepository INSTANCE = new InMemoryRacingCarRepository();
    private final List<RacingCar> RACING_CARS = new ArrayList<>();

    private InMemoryRacingCarRepository() {

    }

    public static InMemoryRacingCarRepository getInstance() {
        return INSTANCE;
    }

    public List<RacingCar> getAll() {
        return new ArrayList<>(RACING_CARS);
    }

    public void addAll(List<RacingCar> racingCars) {
        RACING_CARS.addAll(racingCars);
    }

    @Override
    public void clear() {
        RACING_CARS.clear();
    }
}
