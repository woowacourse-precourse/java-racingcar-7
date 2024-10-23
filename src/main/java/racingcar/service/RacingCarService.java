package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputHandler;

import java.util.List;

public class RacingCarService {

    public void startRace(Race race, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            raceCars(race.getCars());
            race.increaseNumOfMatches();
            OutputHandler.printCarPosition(race.getCars());
        }
    }

    public void raceCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.moveIfPossible(randomNumber);
        }
    }
}
