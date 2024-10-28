package racingcar;

import java.util.LinkedList;

public class CarNameParser {
    static LinkedList<Car> parsingCarName(String carNames) {
        LinkedList<Car> carList = new LinkedList<>();

        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException();
        }

        for (String name : carNames.split(",")) {
            checkCarName(name);
            carList.add(new Car(name.trim(), 0));
        }

        return carList;
    }

    private static void checkCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
