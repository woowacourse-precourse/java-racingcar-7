package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputHandler;

import java.util.ArrayList;
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


    public List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.get(0).getPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
