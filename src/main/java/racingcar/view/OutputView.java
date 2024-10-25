package racingcar.view;

import static racingcar.constant.Constant.*;

import java.util.List;
import racingcar.model.domain.Car;

public class OutputView {

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formatRaceProgress(car));
        }
        System.out.println();
    }

    public void printWinners(String joinedWinnerNames) {
        System.out.println(WINNER_MESSAGE + joinedWinnerNames);
    }

    private String formatRaceProgress(Car car) {
        return String.format(RACE_PROGRESS_FORMAT, car.getCarName(),
                RACE_PROGRESS_SYMBOL.repeat(car.getCurrentDistance()));
    }
}
