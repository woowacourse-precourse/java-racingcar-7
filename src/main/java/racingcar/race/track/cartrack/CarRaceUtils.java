package racingcar.race.track.cartrack;

import racingcar.race.racer.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.race.track.RaceUtils;

public class CarRaceUtils implements RaceUtils<Car> {

    @Override
    public void moveAll(List<Car> cars) {
        for (Car car : cars) {
            boolean canMove = car.canMove();
            car.tryMove(canMove);
        }
    }

    @Override
    public List<String> findWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        List<Integer> distanceList = new ArrayList<>();

        for (Car car : cars) {
            distanceList.add(car.getDistance().length());
        }
        int maxDistance = Collections.max(distanceList);
        for (Car car : cars) {
            if (car.getDistance().length() >= maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
