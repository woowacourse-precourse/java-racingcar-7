package racingcar;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Car> cars;
    private static Integer racingCount;
    private static Integer carCount;

    Data() {
        cars = new ArrayList<>(10);
        racingCount = 0;
        carCount = 0;
    }

    public static void addCarToCarsByName(String name) { cars.add(new Car(name)); }
    public static void setRacingCount(int count) { racingCount = count; }
    public static void setCarCount(int count) { carCount = count; }

    public static ArrayList<Car> getCars() { return cars; }
    public static Integer getRacingCount() { return racingCount; }
    public static Integer getCarCount() { return carCount; }
}