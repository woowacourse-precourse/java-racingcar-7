package repository;

import dto.RacingParam;
import util.Car;

public class CarRepository {
    public static Car[] cars;
    public static int repeatCount;

    public static void saveCarsAndRepeatCount(RacingParam input) {
        cars = input.cars();
        repeatCount = input.repeatCount();
    }

}