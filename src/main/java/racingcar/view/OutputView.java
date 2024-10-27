package racingcar.view;

import static racingcar.constant.InputOutputConstants.SEPARATOR;
import static racingcar.constant.InputOutputConstants.PROGRESS_BAR;
import static racingcar.constant.InputOutputConstants.RESULT_MESSAGE;

import java.util.List;
import racingcar.model.car.Car;

public class OutputView {

    public static void printCarProgress(List<Car> carList) {

        for (Car car : carList) {
            printSingleCarProgress(car);
        }
        printEndLine();
    }

    public static void printWinner(String winners) {

        System.out.println(RESULT_MESSAGE + winners);
    }

    private static void printSingleCarProgress(Car car) {

        System.out.println(car.getName() + SEPARATOR + PROGRESS_BAR.repeat(car.getProgress()));
    }

    private static void printEndLine() {

        System.out.println();
    }
}
