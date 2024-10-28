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
        for(int i = 0; i < racingCounter; i++) {
            printEachTurn(racingCars);
        }
    }
    public static void printEachTurn(ArrayList<RacingCar> racingCars) {
        for(RacingCar racingcar : racingCars) {
            String car = racingcar.getName();
            System.out.print(car + " : " + "\n");

        }
        System.out.print("\n");
    }
}
