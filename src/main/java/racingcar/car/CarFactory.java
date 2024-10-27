package racingcar.car;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CarFactory {
    private static final Pattern VALID_CAR_NAMES_PATTERN = Pattern.compile("^[^,]+(,[^,]+)*$");

    public Set<Car> createCars(String carNames) {
        validateCarNames(carNames);
        return convertCarNamesToCarSet(carNames);
    }

    private void validateCarNames(String carNames) {
        if (carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Blank");
        }
        if (!VALID_CAR_NAMES_PATTERN.matcher(carNames).matches()) {
            throw new IllegalArgumentException("Write valid comma between names");
        }
    }

    private Set<Car> convertCarNamesToCarSet(String input) {
        Set<Car> cars = new HashSet<>();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
