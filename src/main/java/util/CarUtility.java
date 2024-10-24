package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.Car;

public class CarUtility {

    public static ArrayList<Car> makeCarList(String carsWithComma) {
        String[] carNames = carsWithComma.split(",");
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static int makeRandomInt() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void advanceIf4More(Car car) {
        int randomInt = makeRandomInt();
        if (randomInt >= 4) {
            car.addAdvanceCount();
        }
    }
}
