package racingcar;

import console.ConsoleUtil;
import console.Message;
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
            System.out.println(Message.PREFIX_PER_TURN + (i + 1) + Message.SUFFIX_PER_TURN);
            for (Car car : cars) {
                CarUtil.advanceSixTimesOutOfTen(car);
                car.printRacingInfo();
            }
        }
        CarUtil.printWinners(cars);
    }
}
