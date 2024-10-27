package racingcar.game.io;

import racingcar.game.model.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputHandler {
    private static final String WINNER_RESULT_PREFIX = "최종 우승자 : ";
    private static final String ERROR_PREFIX = "에러: ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String POSITION_DISPLAY = "-";

    public void printWinner(List<Car> winners) {
        List<String> winnersName = new ArrayList<>();
        for (Car car : winners) winnersName.add(car.getName());
        System.out.print(WINNER_RESULT_PREFIX);
        System.out.println(String.join(WINNER_DELIMITER, winnersName));
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printCarPosition(Car car) {
        Integer position = car.getPosition();
        String repeatPositionDisplay = POSITION_DISPLAY.repeat(position);
        System.out.println(car.getName() + " : " + repeatPositionDisplay);
        System.out.println();
    }
}
