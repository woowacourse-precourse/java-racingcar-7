package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void outputProcess(int roundNumber,Car car){
        for (int i = 0; i < roundNumber; i++) {
            System.out.print(Car.getCarList().get(i).getName() + " : ");
            List<String> processList = Car.getCarList().get(i).getMoveList();
            System.out.print(String.join(", " ,processList.subList(0,i)));
        }
    }
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
