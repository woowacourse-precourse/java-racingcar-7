package racingcar.persistence;

import java.util.ArrayList;
import java.util.List;
import racingcar.RacingCar;

public class InMemoryRacingCarRepository {

    private static final InMemoryRacingCarRepository INSTANCE = new InMemoryRacingCarRepository();
    private final List<RacingCar> RACING_CARS = new ArrayList<>();

    private InMemoryRacingCarRepository() {

    }

    public static InMemoryRacingCarRepository getInstance() {
        return INSTANCE;
    }

    public void addAll(List<RacingCar> racingCars) {
        RACING_CARS.addAll(racingCars);
    }
}
