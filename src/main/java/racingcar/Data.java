package racingcar;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Car> cars;
    private static Integer racingCount;

    Data() {
        cars = new ArrayList<>(10);
        racingCount = 0;
    }

    public static void addCarToCarsByName(String name) { cars.add(new Car(name)); }
    public static void setRacingCount(int count) { racingCount = count; }

    public static ArrayList<Car> getCars() { return cars; }
    public static Integer getRacingCount() { return racingCount; }
}