package racingcar.view;

import racingcar.common.OutputMaker;
import racingcar.model.Car;
import racingcar.model.Winners;

import java.util.List;

public class OutputView {
    public void printRoundResult(List<Car> cars) {
        System.out.println(OutputMaker.roundResult(cars));
    }

    public void printFinalResult(Winners winners) {
        System.out.println(OutputMaker.finalResult(winners));
    }
}
