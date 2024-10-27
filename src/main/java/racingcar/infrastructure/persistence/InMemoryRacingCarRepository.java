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
    @Override
    public void saveRacingCar(RacingCar racingCar) {
        int existingCarIndex = findCarIndexByName(racingCar.getName());

        if (existingCarIndex != -1) {
            racingCars.set(existingCarIndex, racingCar);
            return;
        }

        racingCars.add(racingCar);
    }

    private int findCarIndexByName(String name) {
        for (int i = 0; i < racingCars.size(); i++) {
            if (racingCars.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // TODO : RacingCar 반환
    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getSize(){
        return racingCars.size();
    }

    public void clear() {
        racingCars.clear();
    }
}
