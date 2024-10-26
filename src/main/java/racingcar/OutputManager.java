package racingcar;

import java.util.ArrayList;
import java.util.Iterator;

public class OutputManager {
    public static void printCurrentResult(RacingCar[] group){
        for(int i = 0; i < group.length; i++){
            System.out.println(group[i]);
        }
        printBlankLine();
    }

    public static void printBlankLine(){
        System.out.println();
    }

    public static void printResult(ArrayList<String> winner){
        System.out.print("최종 우승자 : ");
        Iterator<String> iterator = winner.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            if(iterator.hasNext()){
                System.out.println(", ");
            }
        }
    }
}
