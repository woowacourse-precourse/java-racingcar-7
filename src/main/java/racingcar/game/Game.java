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

    public void start(int loopCnt) {
        racingStart(loopCnt);
        findWinner();
        printWinner();
    }

    private void racingStart(int loopCnt) {
        for (int i = 0; i < loopCnt; i++) {
            racing();
        }
        
        printCurrent();
    }

    private void racing() {
        racingCars.forEach(car -> {
            if (randomNumber() >= 4) {
                car.forwardOne();
            }
        });
    }

    private void printCurrent() {
        racingCars.forEach(car -> {
            System.out.println(car + " : " + car.getLocationString());
        });
        System.out.println();
    }

    private void printWinner() {
        System.out.print("최종 우승자 : ");
        System.out.println(joinWinnerCarNames());
    }

    private String joinWinnerCarNames() {
        String[] carNameArray = winnerCars.stream().map(Car::toString).toArray(String[]::new);

        return String.join(",", carNameArray);
    }

    private void findWinner() {
        int maxLocation = findMaxLocation();

        racingCars.forEach(car -> {
            if (car.getLocation() == maxLocation) {
                winnerCars.add(car);
            }
        });
    }

    private int findMaxLocation() {
        return racingCars.stream()
                .map(Car::getLocation)
                .reduce(0, (identity, location) -> {
                    if (identity < location) {
                        return location;
                    }
                    return identity;
                });
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    private void createCars(String carNames) {
        String[] carNameArray = carNames.split(",");
        Arrays.stream(carNameArray).forEach(name -> racingCars.add(new Car(name)));
    }

}
