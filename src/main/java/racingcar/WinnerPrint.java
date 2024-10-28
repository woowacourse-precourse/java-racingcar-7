package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerPrint {

    protected static List<String> getWinners() {

        int maxNumber = Application.moveCount[0];

        for (int i : Application.moveCount) {

            if (i > maxNumber) {
                maxNumber = i;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Application.moveCount.length; i++) {

            if (Application.moveCount[i] == maxNumber) {
                result.add(Application.nameList.get(i));
            }

        }

        return result;
    }

    public static void winnerPrint() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
