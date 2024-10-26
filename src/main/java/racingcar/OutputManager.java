package racingcar;

import java.util.ArrayList;

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
        System.out.println("최종 결과 : " + winner.toString());
    }
}
