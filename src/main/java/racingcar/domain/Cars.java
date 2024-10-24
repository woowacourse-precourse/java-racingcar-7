package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> findWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int maxMovedDistance = findMaxMovedDistance(cars);
        for (Car car : cars) {
            if (car.getMovedDistance() == maxMovedDistance) {
                winner.add(car);
            }
        }
        return winner;
    }

    private int findMaxMovedDistance(List<Car> cars) {
        int maxMovedDistance = 0;
        for (Car car : cars) {
            if (car.getMovedDistance() > maxMovedDistance) {
                maxMovedDistance = car.getMovedDistance();
            }
        }
        return maxMovedDistance;
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

}
