package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    public int[] racing(String[] carList, int number) {
        int[] racingResult = new int[carList.length];
        for (int i = 0; i < carList.length; i++) {
            racingResult[i] = countMovements(number);
            printRacingResult(carList[i], racingResult[i]);
        }
        System.out.println();
        return racingResult;
    }

    private int countMovements(int number) {
        int count = 0;
        for (int i = 0; i < number; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                count++;
            }
        }
        return count;
    }

    private void printRacingResult(String carName, int racingResult) {
        System.out.print(carName + " : ");
        System.out.println("-".repeat(racingResult));
    }
}
