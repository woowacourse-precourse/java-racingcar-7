package Service;

import camp.nextstep.edu.missionutils.Randoms;
import util.Result;

import java.util.List;

public class RacingCarService {
    public static StringBuilder sb = new StringBuilder();

    // 경주 시작
    public static String run(List<String> car, List<Integer> process, int numTry) {
        for (int i = 0; i < numTry; i++) {
            pickRandom(process);
            sb.append(Result.printOngoing(car, process)).append("\n");
        }

        return sb.toString();
    }

    // 모든 차량이 Random으로 수를 뽑음
    private static void pickRandom(List<Integer> process) {
        for (int i = 0; i < process.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);

            determineMore4(randomNum, i, process);
        }
    }

    // 4 이상인지 판단
    private static void determineMore4(int randomNum, int idx, List<Integer> process) {
        if (randomNum >= 4) {
            process.set(idx, process.get(idx) + 1);
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
