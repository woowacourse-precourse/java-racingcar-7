package racingcar;

import console.ConsoleUtil;
import java.util.ArrayList;
import util.CarUtil;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNames = ConsoleUtil.readCarName();
        int racingCounts = ConsoleUtil.readRacingCount();
        ConsoleUtil.closeConsole();

        ArrayList<Car> cars = CarUtil.makeCarList(carNames);
        for (int i = 0; i < racingCounts; i++) {
            for (Car car : cars) {
                CarUtil.advanceSixTimesOutOfTen(car);
                car.printRacingInfo();
            }
            System.out.println();
        }
        CarUtil.printWinners(cars);
    }
}
