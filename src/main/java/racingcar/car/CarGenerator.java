package racingcar.car;

public class CarGenerator {
    private final static String DELIMITER = ",";

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
