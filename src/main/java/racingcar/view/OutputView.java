package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.Constant;

public class OutputView {

    public void printCarStatus(List<Car> cars) {
        System.out.println(Constant.GAME_RESULT_MESSAGE);

        for (Car car : cars) {
            System.out.printf(Constant.CAR_STATUS_MESSAGE, car.getName(), Constant.MOVE_STRING.repeat(car.getScore()));
        }
    }
}
