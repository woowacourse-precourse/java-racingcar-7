package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private final String name;
    private int mileage;
    private String win;

    private Car(String name) {
        this.name = name;
        this.mileage = 0;
        this.win = "";
    }

    private static Car of(String name) {
        return new Car(name);
    }

    public static List<Car> toList(List<String> names) {
        return names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public static int findMaxMileage(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.mileage)
                .max()
                .orElse(0);
    }

    public boolean hasMaxMileage(int maxMileage) {
        return mileage == maxMileage;
    }

    public void drive() {
        int drive = Randoms.pickNumberInRange(0, 9);
        if (drive >= 4) {
            this.mileage += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getWin() {
        return this.win;
    }

    public void updateWin() {
        this.win += "-";
    }

}
