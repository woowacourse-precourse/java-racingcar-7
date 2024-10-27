package racingcar.domain.race;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.moveProvider.MoveProvider;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResult;

public class RaceManager {

    private final CarFactory carFactory;
    private final RaceFactory raceFactory;
    private final MoveProvider moveProvider;

    public RaceManager(CarFactory carFactory, RaceFactory raceFactory, MoveProvider moveProvider) {
        this.carFactory = carFactory;
        this.raceFactory = raceFactory;
        this.moveProvider = moveProvider;
    }

    public RaceResult startRace(RaceRequest raceRequest) {
        List<Car> cars = carFactory.create(raceRequest.getCarNames());
        Race race = raceFactory.create(cars, moveProvider);

        return race.start(raceRequest.getLapCount());
    }
}