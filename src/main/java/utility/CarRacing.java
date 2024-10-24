package utility;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Application;

import java.util.List;

public class CarRacing {
    // 경주 시작
    public static void start() {
        for (int i = 0; i < Application.numTry; i++) {
            pickRandom(Application.currentSituation);
            Result.printOngoing(Application.cars, Application.currentSituation);
        }
    }

    // 모든 차량이 Random으로 수를 뽑음
    private static void pickRandom(List<Integer> currentSituation) {
        for (int i = 0; i < currentSituation.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            determineMore4(randomNum, i, currentSituation);
        }
    }

    // 4 이상인지 판단
    private static void determineMore4(int randomNum, int idx, List<Integer> currentSituation) {
        if (randomNum >= 4) {
            currentSituation.set(idx, currentSituation.get(idx) + 1);
        }
    }

    // Test
    public static List<Integer> test(int randomNum, List<Integer> progress) {
        try {
            setRandom(randomNum, progress);
            return progress;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error");
        }
    }

    // Random 수 지정
    public static void setRandom(int randomNum, List<Integer> process) {
        for (int i = 0; i < process.size(); i++) {
            determineMore4(randomNum, i, process);
        }
    }
}
