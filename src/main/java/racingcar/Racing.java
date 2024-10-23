package racingcar;

import java.util.ArrayList;

class Racing {

    static ArrayList<Car> generateCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (String car : carNames) {
            cars.add(new Car(car,0));
        }
        return cars;
    }

}
