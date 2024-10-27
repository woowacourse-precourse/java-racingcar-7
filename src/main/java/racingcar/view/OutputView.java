package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.constants.Constants.*;

public class OutputView {

    public static void resultMessage() {
        System.out.println(EXECUTE_RESULT);
    }

    public static void roundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getCurrentPosition());
        }
        System.out.println();
    }

    public static void winnerMessage(String winnerList) {
        System.out.println(WINNER_RESULT + winnerList);
    }
}
