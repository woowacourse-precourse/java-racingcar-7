package racingcar.car;

import java.util.ArrayList;

public class CarGenerator {
    private final static String DELIMITER = ",";
    private final static String NUMBER_REGEX = "^[0-9]+$";

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

    public static void checkIsEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] trimStringArrayElements(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            checkIsEmpty(carNames[i]);
            carNames[i] = carNames[i].trim();
            checkNameLength(carNames[i]);
        }
        return carNames;
    }
}
