package racingcar.view;

import racingcar.message.OutputMessage;
import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void racingResult(){
        System.out.println(OutputMessage.RESULT.getMessage());
    }

    public void racingView(List<Car> cars){
        for (Car car : cars) {
            String positionMark = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + positionMark);
        }
        System.out.println();
    }

    public void resultView(List<String> cars){
        String winnerCars = String.join(",", cars);
        System.out.println(OutputMessage.WINNER.getMessage() + winnerCars);
    }

}
