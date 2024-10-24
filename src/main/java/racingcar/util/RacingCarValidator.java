package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class RacingCarValidator {

    private RacingCarValidator() {

    }

    public static void validateCarNameLength(final String name, final int maxLength) {
        if (isExceedCarNameLength(name, maxLength)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarDuplicate(final List<Car> cars) {
        if (isDuplicateCar(cars)) {
            throw new IllegalArgumentException();
        }
    }

    public static <T extends Number & Comparable<T>> void validateCountValueRange(final T value, final T maxRange) {
        if (isExceedCountValueRange(value, maxRange)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isExceedCarNameLength(final String name, final int maxLength) {
        return name.length() > maxLength;
    }

    private static boolean isDuplicateCar(final List<Car> cars) {
        return cars.stream()
                .distinct()
                .count() != cars.size();
    }

    private static <T extends Comparable<T>> boolean isExceedCountValueRange(final T value, final T maxRange) {
        return value.compareTo(maxRange) > 0;
    }


}
