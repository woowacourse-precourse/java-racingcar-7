package racingcar;

import java.util.ArrayList;

public class RacingController {
    private static int mostMove;

    public static void startRacing() {
        mostMove = 0;
        Printer.printMessage(Constants.RESULT);

        for (int lap = 0; lap < Data.getRacingCount(); lap++) {
            loopForEachCar();
        }
        Printer.printMessage(Constants.WINNER + createWinnerString(Data.getCars()));
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
            setMostMove(curCar.getMoveCount());
        }
    }

    private static void setMostMove(int curMove) {
        if (curMove > mostMove) {
            mostMove = curMove;
        }
    }

    private static String createWinnerString(ArrayList<Car> cars) {
        String winner = "";

        for (Car curCar : cars) {
            if (curCar.getMoveCount() == mostMove) {
                if (winner != "") {
                    winner += ", ";
                }
                winner += curCar.getName();
            }
        }

        return winner;
    }
}