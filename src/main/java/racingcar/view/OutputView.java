package racingcar.view;

import java.util.ArrayList;

public class OutputView {


    public void outputWinnerList(ArrayList<String> winnerList){
        System.out.print("최종 우승자 : ");
        System.out.print(winnerList.get(0));

        if(winnerList.size() > 1){
            for (int i = 1; i < winnerList.size(); i++) {
                System.out.println(", " +  winnerList.get(i));
            }
        }

    }
}
