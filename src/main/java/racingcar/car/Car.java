package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private static final int DRIVING_CONDITION_THRESHOLD = 4;
    private static final int DRIVING = 1;
    private static final String MILEAGE_SYMBOL = "-";

    private final String name;
    private int mileage;

    private Car(String name) {
        this.name = name;
        this.mileage = 0;
    }

    private static Car of(String name) {
        return new Car(name);
    }

    public static List<Car> toList(List<String> names) {
        return names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public boolean matchesMaxMileage(int maxMileage) {
        return mileage == maxMileage;
    }

    public void drive() {
        int drive = Randoms.pickNumberInRange(0, 9);
        if (drive >= DRIVING_CONDITION_THRESHOLD) {
            mileage += DRIVING;
        }
    }

    public String getMileageDisplay() {
        return MILEAGE_SYMBOL.repeat(Math.max(0, mileage));
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

}
