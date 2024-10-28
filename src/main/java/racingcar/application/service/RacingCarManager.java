package racingcar.application.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.persistence.RacingCarRepository;
import racingcar.racing.RacingCarHistoryManager;
import racingcar.racing.CarRaceResult;
import racingcar.racing.Racing;
import racingcar.racing.CarRacer;
import racingcar.application.RacingManager;

public class RacingCarManager implements RacingManager<CarRacer> {

    private final Racing<CarRacer> racing;
    private final RacingCarRepository racingCarRepository;
    private final RacingCarHistoryManager racingCarHistoryManager;
    private final WinnerIdentifier winnerIdentifier;

    public RacingCarManager(Racing<CarRacer> racing, RacingCarRepository racingCarRepository,
            RacingCarHistoryManager racingCarHistoryManager, WinnerIdentifier winnerIdentifier) {
        this.racing = racing;
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
                    racing.start(registeredCars);
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
