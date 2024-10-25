package racingcar.view;

import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.console.Writer;

public class OutputView {

    private static final String RACE_RESULT = "실행 결과";
    private static final String EMPTY = "";

    public void printRaceResultPhrase() {
        Writer.print(RACE_RESULT);
    }

    public void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            Writer.print(car.toString());
        }
        Writer.print(EMPTY);
    }

    public void printWinner(Winners winners) {
        Writer.print(winners.toString());
    }
}
