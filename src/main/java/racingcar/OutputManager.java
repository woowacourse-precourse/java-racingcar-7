package racingcar;

import constant.Constants;
import java.util.ArrayList;

public class OutputManager {
    public static void printCurrentResult(ArrayList<RacingCar> group){
        for(RacingCar racingCar : group){
            System.out.println(racingCar);
        }
        printBlankLine();
    }

    public static void printBlankLine(){
        System.out.println();
    }

    public static void printRaceResult(ArrayList<String> winner){
        System.out.print(Constants.RACING_WINNER_MESSAGE);
        //join 메서드 각 원소를 ", "로 합쳐서 출력 가능
        System.out.println(String.join(Constants.CONTENT_DELIMITER +" ",winner));
    }
}
