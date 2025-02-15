package racingcar.view;

import racingcar.domain.Car;
import racingcar.message.OutputMessage;

import java.util.List;

public class OutputView {

    public void racingResult(){
        System.out.println(OutputMessage.RESULT.getMessage());
    }

    /**
     * 자동차의 이동거리를 출력해주는 메서드
     * @param cars 자동차
     */
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
