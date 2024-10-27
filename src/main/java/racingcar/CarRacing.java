package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    public void racing(List<Car> carList, int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            for (Car car : carList) {
                moveCar(car);
                printCarLocation(car);
            }
            System.out.println();
        }
    }

    public void moveCar(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.move();
        }
    }

    public void printCarLocation(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public List<Car> settingCar(String[] carNames){
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }
}
