package racingcar.car;

import java.util.ArrayList;

public class CarGenerator {
    private final static String DELIMITER = ",";

    public static ArrayList<Car> generateCar(String[] carNames) {
        ArrayList<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public static String[] splitInputString(String inputString) {
        String[] carNames = inputString.split(DELIMITER);
        return trimStringArrayElements(carNames);
    }

    public static void checkNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] trimStringArrayElements(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
            checkNameLength(carNames[i]);
        }
        return carNames;
    }
}
