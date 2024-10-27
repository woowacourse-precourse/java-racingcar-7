package racingcar;

import java.util.Arrays;

public class ResultPrint {
    public static void resultPrint() {
        System.out.println("실행 결과");
        for (int i = 0; i < RacingProcess.carNumber; i++) {
            System.out.println(Application.nameList[i] + " :" +Application.processResult[i]);
        }
        System.out.println();
    }
}
