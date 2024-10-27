package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void outputProcess(int roundNumber){
        System.out.println("실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            for (Car car : Car.getCarList()) {
                System.out.print(car.getName() + " : ");
                List<String> processList = car.getMoveList();
                System.out.print(String.join("" ,processList.subList(0,Math.min(i + 1, processList.size()))));
            }
        }
        System.out.println();
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
