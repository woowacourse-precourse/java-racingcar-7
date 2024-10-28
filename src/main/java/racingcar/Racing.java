package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public void run(String[] names, int count) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        for (int i = 0; i < count; i++) {
            forwardCondition(cars);
            presentStatus(cars);
            System.out.println();
        }

        printWinners(cars);
    }

    public void forwardCondition(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.incrementMoveCount();
            }
        }
    }

    public void presentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            generateDashLine(car);
        }
    }

    public void generateDashLine(Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        int maxMoveCount = findMaxMoveCount(cars);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;
        for (Car car : cars) {
            if (car.getMoveCount() > maxMoveCount) {
                maxMoveCount = car.getMoveCount();
            }
        }
        return maxMoveCount;
    }
}
