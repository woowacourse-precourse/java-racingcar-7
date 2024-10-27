package racingcar.game;

import racingcar.car.Car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private final Set<Car> racingCars = new HashSet<>();
    private final Set<Car> winnerCars = new HashSet<>();

    public Game(String carNames){
        createCars(carNames);
    }

    private void createCars(String carNames) {
        String[] carNameArray = carNames.split(",");
        Arrays.stream(carNameArray).forEach(name -> racingCars.add(new Car(name)));
    }

}
