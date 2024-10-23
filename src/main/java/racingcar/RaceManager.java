package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.move.RandomMoveDecider;
import racingcar.domain.race.CarRace;
import racingcar.domain.race.RacePosition;
import racingcar.io.InputReceiver;
import racingcar.domain.car.CarName;
import racingcar.domain.move.MoveAttempt;
import racingcar.randomGenerator.RandomDigitGenerator;

import java.util.Arrays;
import java.util.List;

public class RaceManager {
    private final InputReceiver inputReceiver;

    public RaceManager(InputReceiver inputReceiver) {
        this.inputReceiver = inputReceiver;
    }

    public void run() {
        String carNamesString = inputReceiver.readInput();
        List<CarName> carNameList = Arrays.stream(carNamesString.split(","))
                .map(CarName::of)
                .toList();
        List<Car> carList = carNameList.stream()
                .map(Car::new)
                .toList();
        RacePosition startPosition = new RacePosition(carList);
        String attemptCountString = inputReceiver.readInput();
        MoveAttempt moveAttempt = MoveAttempt.of(attemptCountString);
        RandomMoveDecider randomMoveDecider = new RandomMoveDecider(RandomDigitGenerator.getInstance());
        CarRace carRace = new CarRace(randomMoveDecider);
        RacePosition resultPosition = carRace.repeatExecution(startPosition, moveAttempt);
        List<Car> farthestCars = resultPosition.findFarthestCar();
    }
}
