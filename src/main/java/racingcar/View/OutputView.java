package racingcar.View;

import java.util.ArrayList;
import racingcar.Constants;

public class OutputView {
    public static void printSimulationStartMessage(){
        System.out.println("\n실행 결과");
    }
    public static void printRoundResult(ArrayList<String> roundResults){
        roundResults.forEach(System.out::println);
        System.out.println();
    }
    public static void printWinners(ArrayList<String> winners){
        System.out.println("최종 우승자 : "+String.join(Constants.WINNER_DELIMITER,winners));
    }
}
