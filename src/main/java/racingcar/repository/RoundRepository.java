package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Round;

public class RoundRepository {

    private static RoundRepository instance;
    private final CarRepository carRepository;

    private RoundRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public static RoundRepository getInstance(CarRepository carRepository) {
        if (instance == null) {
            instance = new RoundRepository(carRepository);
        }
        return instance;
    }

    private int id = 0;
    private Map<Integer, Round> rounds = new HashMap<>();

    public void save(Round round) {
        round.setId(id);

        for (Car car : round.getCarList()) {
            car.addRound(round);
            carRepository.update(car);
        }

        rounds.put(id, round);
        id++;
    }

    public void update(Round round) {
        rounds.replace(round.getId(), round);
    }

    public Round findByRoundId(int id) {
        return rounds.get(id);
    }
}
