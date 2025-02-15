package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void moveCars(List<Car> cars, int attemptNumber, PrintResult printResult) {

        for (int i = 0; i < attemptNumber; i++) {
            moveEachCars(cars, printResult);
            System.out.println();
        }
    }

    private void moveEachCars(List<Car> cars, PrintResult printResult) {
        for(Car car : cars) {
            car.move();
            printResult.printCar(car);
        }
    }

    private int maxWinNumber(List<Car> cars) {
        int maxNumber = cars.getFirst().getForwardCount();
        for (Car car : cars) {
            if (car.getForwardCount() > maxNumber) {
                maxNumber = car.getForwardCount();
            }
        }
        return maxNumber;
    }

    public List<String> maxCarName(List<Car> cars) {
        int maxWinNumber = maxWinNumber(cars);

        List<String> maxCarName = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardCount() == maxWinNumber) {
                maxCarName.add(car.getCarName());
            }
        }
        return maxCarName;
    }
}
