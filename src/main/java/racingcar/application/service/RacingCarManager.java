package racingcar.application.service;

import static racingcar.common.constant.ExceptionMessage.*;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.application.implement.RaceHistoryManager;
import racingcar.application.implement.RaceWinnerIdentifier;
import racingcar.common.constant.ExceptionMessage;
import racingcar.persistence.CarRacerRepository;
import racingcar.application.implement.RaceStarter;
import racingcar.domain.CarRacer;
import racingcar.application.vo.RaceResult;

public class RacingCarManager implements RacingManager<CarRacer> {

    private final RaceStarter<CarRacer> raceStarter;
    private final RaceHistoryManager<CarRacer> raceHistoryManager;
    private final RaceWinnerIdentifier<CarRacer> raceWinnerIdentifier;
    private final CarRacerRepository carRacerRepository;

    public RacingCarManager(RaceStarter<CarRacer> raceStarter, RaceHistoryManager<CarRacer> raceHistoryManager,
            RaceWinnerIdentifier<CarRacer> raceWinnerIdentifier, CarRacerRepository carRacerRepository) {
        this.raceStarter = raceStarter;
        this.raceHistoryManager = raceHistoryManager;
        this.raceWinnerIdentifier = raceWinnerIdentifier;
        this.carRacerRepository = carRacerRepository;
    }

    @Override
    public void registerAll(List<CarRacer> racers) {
        validateDuplicationName(racers);
        carRacerRepository.addAll(racers);
    }

    @Override
    public void raceStart(int gameCount) {
        List<CarRacer> registeredCars = carRacerRepository.getAll();
        IntStream.range(0, gameCount)
                .forEach(count -> {
                    raceStarter.start(registeredCars);
                    raceHistoryManager.record(registeredCars);
                });
    }

    @Override
    public RaceResult<CarRacer> createRaceResult() {
        List<CarRacer> racedCars = carRacerRepository.getAll();
        List<CarRacer> winners = raceWinnerIdentifier.identify(racedCars);
        List<String> carRaceHistories = raceHistoryManager.getAllHistory();
        return RaceResult.of(winners, carRaceHistories);
    }

    private void validateDuplicationName(List<CarRacer> racers) {
        long uniqueCount = racers.stream()
                .map(CarRacer::getName)
                .distinct()
                .count();

        if (uniqueCount != racers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }
}
