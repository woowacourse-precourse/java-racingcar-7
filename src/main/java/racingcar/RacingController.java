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

        for (Car curCar : cars) {
            int randomNum = NumberMaker.makeRandomNumber();
            applyNumberToCar(randomNum, curCar);

            System.out.println("random number: " + randomNum);
            System.out.println("move count: " + curCar.getMoveCount());

            Printer.printRaceResult(curCar);
        }
        System.out.print("\n");
    }

    private static void applyNumberToCar(int randomNumber, Car curCar) {
        if (randomNumber >= 4) {
            curCar.increaseMoveCount();
        }
    }
}