package racingcar.persistence;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarRacer;

public class InMemoryCarRacerRepository implements CarRacerRepository {

    private static final InMemoryCarRacerRepository INSTANCE = new InMemoryCarRacerRepository();
    private final List<CarRacer> RACING_CARS = new ArrayList<>();

    private InMemoryCarRacerRepository() {

    }

    public static InMemoryCarRacerRepository getInstance() {
        return INSTANCE;
    }

    public List<CarRacer> getAll() {
        return new ArrayList<>(RACING_CARS);
    }

    public void addAll(List<CarRacer> carRacers) {
        RACING_CARS.addAll(carRacers);
    }

    @Override
    public void clear() {
        RACING_CARS.clear();
    }
}
