package racingcar.view;

import racingcar.Constants;

import java.util.ArrayList;

import static racingcar.Constants.*;

public class OutputView {

    public static void printResultMesseage(){
        System.out.println(RESULT_MEASSAGE);
    }

    public static void printPlayResult(ArrayList<String> roundResult){
        for(String res:roundResult){
            System.out.println(res);
        }
        System.out.println();
    }
    public static void printWinnerResult(ArrayList<String> winners){
        System.out.println(Constants.WINNER + String.join(", ", winners));
    }
}
