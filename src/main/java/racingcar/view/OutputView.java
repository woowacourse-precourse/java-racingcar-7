package racingcar.view;

import racingcar.model.Car;
import java.util.List;

public class OutputView {

    public void printRoundResult(List<Car> cars) {

        StringBuilder sb = new StringBuilder();
        for(Car car : cars) {
            sb.append(car.getName()+" : ");
            sb.append("-".repeat(Math.max(0, car.getPosition())));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void printWinner(String winnerName){
        System.out.println("최종 우승자 : "+winnerName);
    }
}
