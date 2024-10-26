package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    public static void randomlyProceed(int[] distances, int car){
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            distances[car] += 1;
        }
    }
}
