package racingcar;

import java.util.ArrayList;

public class RacingController {
    public static void startRacing() {
        Printer.printMessage(Constants.RESULT);

        for (int lap = 0; lap < Data.getRacingCount(); lap++) {
            loopForEachCar();
        }
    }

    private static void loopForEachCar() {
        ArrayList<Car> cars = Data.getCars();

        for (int turn = 0; turn < Data.getCarCount(); turn++) {
            int randomNum = NumberMaker.makeRandomNumber();
            applyNumberToCar(randomNum, cars.get(turn));

            System.out.println("turn: " + turn);
            System.out.println("random number: " + randomNum);
            System.out.println("move count: " + cars.get(turn).getMoveCount());
        }
    }

    private static void applyNumberToCar(int randomNumber, Car curCar) {
        if (randomNumber <= 4)
            curCar.increaseMoveCount();
    }
}