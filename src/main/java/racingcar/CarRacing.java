package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRacing {

    public static void moveCar(int[] carLocations) {
        for (int i = 0; i < carLocations.length; i++) {
            if (Randoms.pickNumberInRange(0,9) >= 4) {
                carLocations[i] ++;
            }
        }
    }

    public static void printCarLocation(String[] carNames, int[] carLocations) {
        for (int i = 0; i < carLocations.length; i++) {
            System.out.print(carNames[i] + " : " );
            for (int j = 0; j < carLocations[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
