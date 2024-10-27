package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printProcessResult(){
        System.out.println("실행 결과");
    }
    public static void printRoundResult(List<String> currentStates){
        for (String currentState : currentStates){
            System.out.println(currentState);
        }
        System.out.println();

    }

    public static void printWinner(List<String> winners){
        if (winners.size() == 1){
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else{
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }

    }
}
