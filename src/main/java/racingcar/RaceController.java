package racingcar;

import java.util.ArrayList;

public class RaceController {
    private static int mostMove;

    public static void startRacing() {
        resetRace();
        informStartRacing();
        loopForEachLap();
        informWinner();
    }

    private static void resetRace() {
        mostMove = 0;
    }

    private static void informStartRacing() {
        Printer.printMessage(Constants.RESULT);
    }

    private static void loopForEachLap() {
        for (int lap = 0; lap < Data.getRacingCount(); lap++) {
            loopForEachCar();
        }
    }

    private static void loopForEachCar() {
        ArrayList<Car> cars = Data.getCars();

        for (Car curCar : cars) {
            int randomNum = NumberMaker.makeRandomNumber();
            applyNumberToCar(randomNum, curCar);
            informStateOfCar(curCar);
        }
        System.out.print("\n");
    }

    private static void applyNumberToCar(int randomNumber, Car curCar) {
        if (randomNumber >= 4) {
            curCar.increaseMoveCount();
            setMostMove(curCar.getMoveCount());
        }
    }

    private static void informStateOfCar(Car car) {
        Printer.printMessage(createResultMessage(car));
    }

    private static String createResultMessage(Car car) {
        String result = car.getName() + " : ";

        for (int i = 0; i < car.getMoveCount(); i++) {
            result += '-';
        }

        return result;
    }

    private static void setMostMove(int curMove) {
        if (curMove > mostMove) {
            mostMove = curMove;
        }
    }

    private static String createWinnerString(ArrayList<Car> cars) {
        String winnerString = "";

        for (Car curCar : cars) {
            winnerString += extractWinnerName(curCar, winnerString);
        }

        return winnerString;
    }

    private static String extractWinnerName(Car curCar, String winnerString) {
        if (curCar.getMoveCount() == mostMove) {
            return divideStringByComma(winnerString) + curCar.getName();
        }
        return "";
    }

    private static String divideStringByComma(String winnerString) {
        if (winnerString != "") {
            return ", ";
        }
        return "";
    }

    private static void informWinner() {
        Printer.printMessage(Constants.WINNER + createWinnerString(Data.getCars()));
    }
}