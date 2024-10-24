package racingcar;

import java.util.ArrayList;

public class RacingGame {
    public static final int NAME_MAX = 5;

    public String[] createName(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > NAME_MAX) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다");
            }
        }
        return names;
    }

    public ArrayList<Car> createCars(String[] names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

}
