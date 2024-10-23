package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputHandler {
    private static final String RESULT_NOTICE_PHRASE = "\n실행 결과";
    private static final String WINNER_NOTICE_PHRASE = "최종 우승자";
    private static final String STATUS_BAR = "-";
    private static final String DELIMITER = " : ";
    private boolean isFirstPrint = true;

    public void printStatus(List<Car> cars) {
        if (isFirstPrint) {
            System.out.println(RESULT_NOTICE_PHRASE);
            isFirstPrint = false;
        }

        for (Car car : cars) {
            String visualBar = STATUS_BAR.repeat(car.getPosition());
            System.out.println(car.getName() + DELIMITER + visualBar);
        }
        printNewLine();
    }

    public void printWinner(List<Car> winnerCars) {
        List<String> winnerNames = winnerCars.stream().map(Car::getName).toList();
        String winnerName = String.join(DELIMITER, winnerNames);
        System.out.println(WINNER_NOTICE_PHRASE + DELIMITER + winnerName);
    }

    private void printNewLine() {
        System.out.println();
    }
}
