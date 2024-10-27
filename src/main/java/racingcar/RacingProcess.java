package racingcar;

import java.util.Arrays;

public class RacingProcess {

    public static int carNumber = Application.nameList.length;

    public static void racingProcess() {

        int[] processNum = new int[carNumber];
        Arrays.fill(processNum, -1);

        for (int i = 0; i < carNumber; i++) {

            processNum[i] = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);

        }

        for (int i = 0; i < carNumber; i++) {

            if (processNum[i] >= 4) {

                Application.processResult[i] += "-";
                Application.moveCount[i]++;

            }
        }
    }
}
