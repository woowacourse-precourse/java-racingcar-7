package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class WinnerService {

    public static List<String> selectWinner(Cars cars) {
        List<Car> racingCars = cars.getRacingCars();
        List<String> winners = new ArrayList<>();
        int winningCondition = winningCondition(racingCars);
        for (Car car: racingCars){
            addWinner(car, winningCondition, winners);
        }
        return winners;
    }

    private static void addWinner(Car car, int winningCondition, List<String> winners) {
        if (winningCondition== car.getPosition().length()){
            winners.add(car.getName());
        }
    }

    private static int winningCondition(List<Car> racingCars){
        int max = 0;
        for (Car car: racingCars){
            max = getMax(car, max);
        }
        return max;
    }

    private static int getMax(Car car, int max) {
        if (max < car.getPosition().length()){
            max = car.getPosition().length();
        }
        return max;
    }

}
