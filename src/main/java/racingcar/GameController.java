package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public List<Car> mapToCarArray(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    public void moveCars(List<Car> cars, int attemptNumber) {
        PrintResult printResult = new PrintResult();
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                car.move();
                printResult.printCar(car);
            }
            System.out.println();
        }
    }

    public int maxWinNumber(List<Car> cars) {
        int maxNumber = cars.get(0).getForwardCount();
        for (Car car : cars) {
            if (car.getForwardCount() > maxNumber) {
                maxNumber = car.getForwardCount();
            }
        }
        return maxNumber;
    }

    public void maxCarName(List<Car> cars) {
        PrintResult printResult = new PrintResult();

        int maxWinNumber = maxWinNumber(cars);

        List<String> maxCarName = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardCount() == maxWinNumber) {
                maxCarName.add(car.getCarName());
            }
        }
        printResult.printWinner(maxCarName);
    }
}
