package racingcar;

import constant.Constants;
import java.util.ArrayList;
import java.util.Iterator;

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
        Iterator<String> iterator = winner.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            if(iterator.hasNext()){
                System.out.println(", ");
            }
        }
    }
}
