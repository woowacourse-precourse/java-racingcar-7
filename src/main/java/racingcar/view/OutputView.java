package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printCarList(List<Car>carList){
        for (Car car:carList){
            System.out.println(car.getName()+" : "+car.getDashes());
        }
        System.out.println();
    }
    public void printWinner(List<String>winners){
        System.out.print("최종 우승자 : ");

        for(int i=0;i<winners.size();i++){
            System.out.print(winners.get(i));
            if(i<winners.size()-1){
                System.out.print(", ");
            }
        }
    }
}
