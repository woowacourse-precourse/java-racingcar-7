package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printRoundResults(List<String> roundResults){
        for(String result : roundResults){
            System.out.println(result);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners){
        System.out.printf("최종 우승자 : " + String.join(", " , winners));
    }

    public static void printResultMessage(){
        System.out.println("실행 결과");
    }
}