package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerPrint {
    public static void winnerPrint() {

        int maxNumber = Application.resultNum[0];

        for (int i : Application.resultNum) {
            if (i > maxNumber) {
                maxNumber = i;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Application.resultNum.length; i++) {
            if (Application.resultNum[i] == maxNumber) {
                result.add(Application.nameList[i]);
            }
        }

        System.out.println("최종 우승자 : " + String.join(",",result));
    }
}
