package racingcar.domain;

import racingcar.view.InputGameView;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private int remainRounds;
    private final Random random = new Random();
    private InputGameView inputGameView;

    public RacingGame(List<Car> cars, int remainRounds) {
        this.cars = cars;
        this.remainRounds = remainRounds;
    }

    public boolean isFinished(){
        return remainRounds <= 0;
    }

    public void play(){
        cars.forEach(car -> car.move(randomValue()));
        remainRounds--;
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<String> getWinner(){
        int maxDistance=cars.stream()
                .mapToInt(Car::getCount)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getCount()==maxDistance)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public int randomValue(){
        return random.nextInt(10);
    }
}
