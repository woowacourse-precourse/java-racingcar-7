package racingcar.application.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.application.implement.RacingHistoryManager;
import racingcar.application.implement.WinnerIdentifier;
import racingcar.persistence.RacingCarRepository;
import racingcar.application.implement.RaceStarter;
import racingcar.domain.CarRacer;
import racingcar.vo.RaceResult;

public class RacingCarManager implements RacingManager<CarRacer> {

    private final RaceStarter<CarRacer> raceStarter;
    private final RacingCarRepository racingCarRepository;
    private final RacingHistoryManager<CarRacer> racingHistoryManager;
    private final WinnerIdentifier<CarRacer> winnerIdentifier;

    public RacingCarManager(RaceStarter<CarRacer> raceStarter, RacingCarRepository racingCarRepository,
            RacingHistoryManager<CarRacer> racingHistoryManager, WinnerIdentifier<CarRacer> winnerIdentifier) {
        this.raceStarter = raceStarter;
        this.racingCarRepository = racingCarRepository;
        this.racingHistoryManager = racingHistoryManager;
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
                    racingHistoryManager.record(registeredCars);
                });
    }

    @Override
    public RaceResult<CarRacer> createRaceResult() {
        List<CarRacer> racedCars = racingCarRepository.getAll();
        List<CarRacer> winners = winnerIdentifier.identify(racedCars);
        List<String> carRaceHistories = racingHistoryManager.getAllHistory();
        return RaceResult.of(winners, carRaceHistories);
    }
}
