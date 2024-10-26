package racingcar.View;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
    public static final String EXECUTION_RESULT_HEADER = "실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void printExecutionResultHeader() {
        System.out.println("\n"+EXECUTION_RESULT_HEADER);
    }

    public void printExecutionStatus(LinkedHashMap<String, String> raceStatus) {
        raceStatus.forEach((carName, status) -> System.out.println(carName + " : " + status));
        System.out.println();
    }

    public void printFinalWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

}
