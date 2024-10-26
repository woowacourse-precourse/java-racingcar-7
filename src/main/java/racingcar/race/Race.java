package racingcar.race;

import java.util.List;
import racingcar.car.Car;
import racingcar.io.Output;

public class Race {
//    private final Cars cars; // TODO

    public void startRace(List<Car> cars, int numOfRounds) {
        Output.printRoundResultMessage();
        for (int round = 0; round < numOfRounds; round++) {
            playRound(cars);
            Output.printRoundResult(cars);
        }
    }

    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomNumber.createRandomNumber());
        }
    }
}
