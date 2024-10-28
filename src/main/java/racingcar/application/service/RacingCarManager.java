package racingcar.application.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.application.implement.WinnerIdentifier;
import racingcar.persistence.RacingCarRepository;
import racingcar.application.implement.RacingCarHistoryManager;
import racingcar.vo.CarRaceResult;
import racingcar.application.implement.RaceStarter;
import racingcar.domain.CarRacer;

public class RacingCarManager implements RacingManager<CarRacer> {

    private final RaceStarter<CarRacer> raceStarter;
    private final RacingCarRepository racingCarRepository;
    private final RacingCarHistoryManager racingCarHistoryManager;
    private final WinnerIdentifier winnerIdentifier;

    public RacingCarManager(RaceStarter<CarRacer> raceStarter, RacingCarRepository racingCarRepository,
            RacingCarHistoryManager racingCarHistoryManager, WinnerIdentifier winnerIdentifier) {
        this.raceStarter = raceStarter;
        this.racingCarRepository = racingCarRepository;
        this.racingCarHistoryManager = racingCarHistoryManager;
        this.winnerIdentifier = winnerIdentifier;
    }

    @Override
    public void registerAll(List<CarRacer> racers) {
        racingCarRepository.addAll(racers);
    }

    @Override
    public void raceStart(int gameCount) {
        List<CarRacer> registeredCars = racingCarRepository.getAll();
        IntStream.range(0, gameCount)
                .forEach(count -> {
                    raceStarter.start(registeredCars);
                    racingCarHistoryManager.record(registeredCars);
                });
    }

    @Override
    public CarRaceResult createRaceResult() {
        List<CarRacer> racedCars = racingCarRepository.getAll();
        List<CarRacer> winners = winnerIdentifier.identify(racedCars);
        List<String> carRaceHistories = racingCarHistoryManager.getAllHistory();
        return CarRaceResult.of(winners, carRaceHistories);
    }
}
