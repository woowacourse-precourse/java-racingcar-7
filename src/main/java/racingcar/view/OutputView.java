package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.DataTransFormer;

import java.util.ArrayList;

public class OutputView {
    private OutputView() {
    }

    public static void printNoticeBeforeResult() {
        ViewMessage.printInitResultMessage();
    }

    public static void printIntermediateResult(ArrayList<Car> carList) {
        for (Car car : carList) {
            printEachCarResult(car);
        }
        System.out.println();
    }

    private static void printEachCarResult(Car car) {
        System.out.println(makeResult(car));
    }

    private static String makeResult(Car car) {
        return car.getCarName() + " : " + DataTransFormer.makeIntToRacingResult(car.getMileage());
    }

    public static void printWinnerName(String winners) {
        ViewMessage.printFinalWinnerMessage();
        System.out.println(winners);
    }
}
