package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

class Racing {
    static ArrayList<Car> generateCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (String name : carNames) {
            cars.add(new Car(name,0));
        }
        return cars;
    }

    static boolean move() {
        int random = Randoms.pickNumberInRange(0,10);
        return random >= 4;
    }

    static void race(ArrayList<Car> cars) {
        for (Car car: cars) {
            if (move()) {
                car.position += 1;
            }
            Print.printPosition(car);
        }
        System.out.println();
    }

}
