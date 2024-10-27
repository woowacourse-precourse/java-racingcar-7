package racingcar;

import java.util.Arrays;

public class RacingProcess {

    public static int carNumber = Application.nameList.length;

    public static void racingProcess() {

        int[] processNum = generateRandomNumbers(carNumber);

        for (int i = 0; i < carNumber; i++) {

            if (processNum[i] >= 4) {

                Application.processResult[i] += "-";
                Application.moveCount[i]++;

            }
        }
    }

    protected static int[] generateRandomNumbers(int num) {
        int[] randomIntArray = new int[num];
        Arrays.fill(randomIntArray, -1);

        for (int i = 0; i < carNumber; i++) {

            randomIntArray[i] = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);

        }

        return randomIntArray;
    }
}
