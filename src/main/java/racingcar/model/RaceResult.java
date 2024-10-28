package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    public List<Car> getWinner(Cars cars) {
        int maxDistance = getMaxDistance(cars);
        List<Car> winner = new ArrayList<>();
        for(Car car : cars.getCarList()) {
            if(car.getPosition() == maxDistance)
                winner.add(car);
        }
        return winner;
    }

    private int getMaxDistance(Cars cars) {
        int maxDistance = 0;
        for(Car car : cars.getCarList()) {
            if(car.getPosition() > maxDistance)
                maxDistance = car.getPosition();
        }
        return maxDistance;
    }
}
