package racingcar.view;

import java.util.List;

public class OutputView {

    private final int startIndex = 0;

    public void printDefault(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCarsMove(String carDetailList){
        System.out.println(carDetailList);
    }

    public void printWinner(List<String> winner){
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }

}
