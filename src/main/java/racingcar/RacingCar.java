package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private static void randomlyProceed(int[] distances, int car){
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            distances[car] += 1;
        }
    }
    public static void printProcess(int times, String[] names, int[] distances){
        for (int i=0; i<times; i++){
            for (int j=0; j<names.length; j++) {
                randomlyProceed(distances, j);
                System.out.println(names[j] + " : " + "-".repeat(distances[j]));
            }
            System.out.println("");
        }
    }
}
