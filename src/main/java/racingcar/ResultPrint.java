package racingcar;

public class ResultPrint {
    public static void resultPrint() {

        for (int i = 0; i < RacingProcess.carNumber; i++) {

            System.out.println(Application.nameList[i] + " : " +Application.processResult[i]);

        }

        System.out.println();
    }
}
