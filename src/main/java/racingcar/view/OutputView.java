package racingcar.view;

import java.util.List;
import static racingcar.view.constants.Notice.EXCUTOIN_NOTICE;
import static racingcar.view.constants.Notice.WINNER_NOTICE;

public class OutputView {

    public static void printProcessResult(){
        System.out.println(EXCUTOIN_NOTICE.getMessage());
    }
    public static void printRoundResult(List<String> carsPositions){
        for (String carPosition : carsPositions){
            System.out.println(carPosition);
        }
        System.out.println();

    }

    public static void printWinner(String winners){
        System.out.println(WINNER_NOTICE.getMessage() + winners);
    }
}
