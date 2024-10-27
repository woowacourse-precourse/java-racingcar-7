package racingcar.model;

import static java.util.Comparator.comparing;
import static racingcar.view.OutputView.printOnceCarResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Race {
    public static List<Car> raceStart(Integer raceCount, List<Car> cars) {
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                runCarOnce(car);
            }
            printOnceCarResult(cars);
        }
        return getWinner(cars);
    }

    public static boolean shouldMove(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public static void runCarOnce(Car car){
        if (shouldMove()){
            car.moveForward();
        }
    }

    public static List<Car> getWinner(List<Car> cars) {
        List<Car> winnerCandidate = cars;
        Car winningCar = cars.stream().max(comparing(Car::getPosition)).orElse(null);
        int maxMove;
        if (winningCar != null) {
            maxMove = winningCar.getPosition();
        } else {
            maxMove = 0;
        }
        List<Car> winningCars = new ArrayList<>();

        while (winningCar != null){
            winningCars.add(winningCar);
            winnerCandidate.remove(winningCar);
            winningCar = winnerCandidate.stream()
                    .filter(car -> maxMove == car.getPosition())
                    .findAny()
                    .orElse(null);
        }
        return winningCars;
    }
}
