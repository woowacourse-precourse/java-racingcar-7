package racingcar.service;

import racingcar.model.Car;
import racingcar.utils.RandomNumberGanerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private static final int MOVE_LIMIT = 4;
    private static final int MOVE_DISTANCE = 1;
    private static final int INITIAL_POSITION = 0;
    private final List<Car> carList;

    public RacingCarService(List<String> validNames) {
        this.carList = new ArrayList<>();
        for (String name : validNames) {
            this.carList.add(new Car(name, INITIAL_POSITION));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinningCars() {
        int maxDistance = findMaxDistance();

        return carList.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_POSITION);
    }

    public void playRound(){
        carList.forEach(car -> {
            if(canMove(RandomNumberGanerator.generate())){
                car.goFoward(MOVE_DISTANCE);
            }
        });
    }

    private boolean canMove(int number) {
        return number >= MOVE_LIMIT;
    }
}
