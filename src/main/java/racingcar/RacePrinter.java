package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacePrinter {

    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println("-".repeat(car.getPosition()));
    }

    public void printFinalWinners(List<Car> cars) {
        int maxPosition;
        List<String> winnerNames;

        maxPosition = findMaxPosition(cars);
        winnerNames = findWinnerNames(cars, maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition;

        maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findWinnerNames(List<Car> cars, int maxPosition) {
        List<String> winnerNames = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
