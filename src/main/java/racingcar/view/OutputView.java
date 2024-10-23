package racingcar.view;

import racingcar.global.enums.PrintMessage;
import racingcar.model.Cars;

public class OutputView {
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printMessage(PrintMessage message) {
        System.out.println(message.getMessage());
    }

    public void printGameResult(Cars cars) {
        cars.getCarList().forEach(
                car -> System.out.println(car.getName() + " : " + "-".repeat(car.getDistance())
                ));
        printMessage(PrintMessage.EMPTY_MESSAGE);
    }

    public void printWinner(String winners) {
        System.out.println(PrintMessage.WINNER_MESSAGE.getMessage() + winners);
    }

}
