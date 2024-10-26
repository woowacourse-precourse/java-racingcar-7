package racingcar.view;

import java.util.List;

public class OutputView {

    private final int startIndex = 0;
    public void print(String winner){
        System.out.printf("최종 우승자 : %s\n", winner);
    }

    public void printCarsMove(List<String> carDetailList){
        for(int i = startIndex; i < carDetailList.size(); i++){
            System.out.println(carDetailList);
        }
    }

}
