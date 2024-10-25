package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Validator;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validate();
    }

    public static Cars from(List<Car> cars){
        return new Cars(cars);
    }

    private void validate() {
        Validator.containDuplicate(getCarNames());
    }

    public void allMove() {
        for (Car car : cars) {
            car.move(new RandomMovementStrategy());
        }
    }

    public List<String> findRaceWinners() {
        int maxDistance = findMaxDistance();
        return findWinners(maxDistance);
    }

    private List<String> findWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (maxDistance < car.getDistance()) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }
    
    public List<Integer> getCarsPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getDistance());
        }
        return positions;
    }

}
