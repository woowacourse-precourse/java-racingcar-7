package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.car.Car;

public class Game {

    private final Set<Car> racingCars = new HashSet<>();
    private final Set<Car> winnerCars = new HashSet<>();

    public Game(String carNames) {
        createCars(carNames);
    }

    public void start() {
        racingStart();
        findWinner();
        printWinner();
    }

    private void racingStart() {
        racingCars.forEach(car -> {
            if (randomNumber() >= 4) {
                car.forwardOne();
            }
        });

        printCurrent();
    }

    private void printCurrent() {
        racingCars.forEach(car -> {
            System.out.println(car + " : " + car.getLocationString());
        });
        System.out.println();
    }

    private void printWinner() {
    }

    private void findWinner() {
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    private void createCars(String carNames) {
        String[] carNameArray = carNames.split(",");
        Arrays.stream(carNameArray).forEach(name -> racingCars.add(new Car(name)));
    }

}
