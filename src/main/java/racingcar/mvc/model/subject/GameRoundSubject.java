package racingcar.mvc.model.subject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import racingcar.mvc.model.observer.Car;
import racingcar.mvc.model.observer.CarObserver;

public class GameRoundSubject implements Subject {
    private List<CarObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(CarObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (CarObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public List<CarObserver> findWinnerObservers() {
        List<CarObserver> result = new ArrayList<>();

        for (CarObserver observer : observers) {
            Car car = (Car) observer;

            if (car.getDistance().equals(findMaxDistance())) {
                result.add(car);
            }
        }

        return result;
    }

    private BigInteger findMaxDistance() {
        BigInteger maxDistance = BigInteger.ZERO;

        for (CarObserver observer : observers) {
            Car car = (Car) observer;

            if (maxDistance.compareTo(car.getDistance()) < 0) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }
}
