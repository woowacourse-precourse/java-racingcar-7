package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Validator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private void validate() {
        Validator.containDuplicate(extractCarNames(cars));
    }

    public void allMove() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> findRaceWinners() {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();
        findMaxDistance(maxDistance);
        createWinners(maxDistance, winners);
        return winners;
    }

    private void createWinners(int maxDistance, List<String> winners) {
        for (Car car : cars) {
            if (maxDistance == car.getDistance()) {
                winners.add(car.getName());
            }
        }
    }

    private int findMaxDistance(int maxDistance) {
        for (Car car : cars) {
            if (maxDistance < car.getDistance()) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }


    public List<String> extractCarNames(List<Car> cars) {
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

    public List<String> getCarNames() {
        return extractCarNames(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

}
