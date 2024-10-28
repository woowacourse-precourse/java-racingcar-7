package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printUpdatedRecord(String updatedRecord) {
        System.out.println(updatedRecord);
    }

    public static void printWinner(List<String> winner) {
        String result = String.join(",", winner);

        System.out.println("최종 우승자 : " + result);
    }

    public static void printNewLine() {
        System.out.println();
    }

}
