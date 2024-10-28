package racingcar.racing;

import java.util.List;
import racingcar.persistence.RacingCarHistoryRepository;

public class CarRaceHistoryManager {

    private final RacingCarHistoryRepository repository;
    private final CarRaceHistoryWriter writer;

    public CarRaceHistoryManager(RacingCarHistoryRepository repository, CarRaceHistoryWriter writer) {
        this.repository = repository;
        this.writer = writer;
    }

    public void record(List<CarRacer> carRacers) {
        String result = writer.writeAll(carRacers);
        repository.add(result);
    }

    public List<String> getAllHistory() {
        return repository.getHistories();
    }
}
