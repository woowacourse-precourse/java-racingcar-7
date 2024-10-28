package racingcar.application.implement;

import java.util.List;
import racingcar.persistence.RacingCarHistoryRepository;
import racingcar.domain.CarRacer;

public class CarRaceHistoryManager implements RaceHistoryManager<CarRacer> {

    private final RacingCarHistoryRepository repository;
    private final CarRaceHistoryWriter writer;

    public CarRaceHistoryManager(RacingCarHistoryRepository repository, CarRaceHistoryWriter writer) {
        this.repository = repository;
        this.writer = writer;
    }

    @Override
    public void record(List<CarRacer> carRacers) {
        String result = writer.writeAll(carRacers);
        repository.add(result);
    }

    @Override
    public List<String> getAllHistory() {
        return repository.getHistories();
    }
}
