package utility;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Application;

import java.util.List;

public class CarRacing {
    // 경주 시작
    public static void start(){
        for (int i = 0; i < Application.numTry; i++) {
            pickRandom();
            Result.printOngoing();
        }
    }

    // 모든 차량이 Random으로 수를 뽑음
    public static void pickRandom() {
        List<Integer> tmpCurrentSituation = Application.currentSituation;

        for (int i = 0; i < tmpCurrentSituation.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            determineMore4(randomNum, i);
        }
    }

    // 4 이상인지 판단
    public static void determineMore4(int randomNum, int idx) {
        List<Integer> tmpCurrentSituation = Application.currentSituation;

        if (randomNum >= 4) {
            tmpCurrentSituation.set(idx, tmpCurrentSituation.get(idx) + 1);
        }
    }
}
