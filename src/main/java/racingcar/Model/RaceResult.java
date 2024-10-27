package racingcar.Model;

import java.util.List;
import java.util.ArrayList;

public class RaceResult {
    private List<Car> winners = new ArrayList<>();
    private int maxDistance = 0;

    public void calculateWinners(List<Car> cars) {
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                winners.clear();
                winners.add(car);
            } else if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
    }

    public void printWinners() {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new));
        System.out.println("최종 우승자: " + winnerNames);
    }
}
