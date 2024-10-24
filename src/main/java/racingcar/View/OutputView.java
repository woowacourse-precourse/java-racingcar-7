package racingcar.View;

import java.util.ArrayList;
import racingcar.Constants;

public class OutputView {
    public static void printSimulationStartMessage(){
        System.out.println("\n실행 시작");
    }
    public static void printRoundResult(ArrayList<String> roundResults){

    }
    public static void printWinners(ArrayList<String> winners){
        System.out.println("최종 우승자 : "+String.join(Constants.WINNER_DELIMITER,winners));
    }
}
