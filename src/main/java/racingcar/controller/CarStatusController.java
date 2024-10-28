package racingcar.controller;


import static racingcar.model.RaceCars.getParticipantCars;

import java.util.ArrayList;
import racingcar.model.CarInfo;

public class CarStatusController {
    public final static String DASH = "-";


    public static void printCarStatus() {
        for (CarInfo car : getParticipantCars()) {
            System.out.print(car.getCarName() + " : ");
            printDash(car);
            System.out.println();
        }
    }

    public static void printDash(CarInfo car) {
        for (int i = 0; i < car.moveCount; i++) {
            System.out.print(DASH);
        }
    }

}
