package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingController {


    public static ArrayList<Boolean> setMoveCondition(int racingCounter) {
        ArrayList<Boolean> moveCondition = new ArrayList<Boolean>();
        for (int i = 0; i < racingCounter; i++) {
            moveCondition.add(Randoms.pickNumberInRange(0, 9) >= 4);
        }
        return moveCondition;
    }

    public static void printRacing(ArrayList<RacingCar> racingCars, int racingCounter) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < racingCounter; i++) {
            printEachTurn(racingCars, i);
            System.out.println();
        }
    }


    private static void printEachTurn(ArrayList<RacingCar> racingCars, int turn) {
        for (RacingCar racingCar : racingCars) {
            String carName = racingCar.getName();
            System.out.print(carName + " : ");

            ArrayList<Boolean> moveCondition = racingCar.getMoveCondition();
            if (moveCondition.get(turn)) {
                racingCar.move();
            }

            printCarPosition(racingCar);
            System.out.println();
        }
    }

    private static void printCarPosition(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static ArrayList<String> judgeWinner(ArrayList<RacingCar> racingCars) {
        ArrayList<String> winners = new ArrayList<>();

        int maxPosition = 0;
        for(RacingCar rc : racingCars) {
            maxPosition = Integer.max(maxPosition, rc.getPosition());
        }

        for (RacingCar rc : racingCars) {
            if (rc.getPosition() == maxPosition) {
                winners.add(rc.getName());
            }
        }

        return winners;
    }



}
