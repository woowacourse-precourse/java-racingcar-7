package racingcar.view;

import racingcar.model.Car;
import racingcar.util.Constants;

import java.util.List;

public class OutputView {

    public void printRoundResult() {
        System.out.println(Constants.ROUND_RESULT);
    }

    public void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + Constants.ROUND_RESULT_DELIMITER + Constants.MOVE.repeat(car.getDistance()));
        }
        // 라운드 간 간격을 위한 빈 줄 출력
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(Constants.WINNER_RESULT + String.join(Constants.DELIMITER_WINNER, winners));
    }
}
