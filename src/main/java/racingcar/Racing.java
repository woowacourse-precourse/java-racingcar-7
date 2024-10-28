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
}
