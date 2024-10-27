package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    static public void runRacing(int num, String[] carList) {
        int[] carIndex = new int[carList.length];

        for (int i = 0; i < num; i++) {
            for (int k = 0; k < carList.length; k++) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if (randomValue >= 4) {
                    carIndex[k]++;
                }
            }

            for (int j = 0; j < carList.length; j++) {
                System.out.println(carList[j] + " : " + "-".repeat(carIndex[j]));
            }
            System.out.println();
        }
        maxDistance(carIndex, carList);
    }

    static public void maxDistance(int[] carIndex, String[] carList) {
        int maxDistance = 0;
        for (int distance : carIndex) {
            maxDistance = Math.max(maxDistance, distance);
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carIndex.length; i++) {
            if (carIndex[i] == maxDistance) {
                winners.add(carList[i]);
            }
        }
        printWinner(winners);
    }

    static public void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
