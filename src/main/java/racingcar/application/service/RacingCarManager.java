package racingcar.application.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.persistence.RacingCarRepository;
import racingcar.racing.CarRaceResult;
import racingcar.racing.Race;
import racingcar.racing.RacingCar;
import racingcar.application.RacingManager;

public class RacingCarManager implements RacingManager<RacingCar> {

    private final Race<RacingCar> race;
    private final RacingCarRepository racingCarRepository;
    private final WinnerIdentifier winnerIdentifier;

    public RacingCarManager(Race<RacingCar> race, RacingCarRepository racingCarRepository,
            WinnerIdentifier winnerIdentifier) {
        this.race = race;
        this.racingCarRepository = racingCarRepository;
        this.winnerIdentifier = winnerIdentifier;
    }

    @Override
    public void registerAll(List<RacingCar> racers) {
        racingCarRepository.addAll(racers);
    }

    @Override
    public void raceStart(int gameCount) {
        List<RacingCar> registeredCars = racingCarRepository.getAll();
        IntStream.range(0, gameCount)
                .forEach(count -> race.start(registeredCars));
    }

    @Override
    public CarRaceResult getCarRaceResult() {
        List<RacingCar> racedCars = racingCarRepository.getAll();
        List<RacingCar> winners = winnerIdentifier.identify(racedCars);
        return null;
    }
}
