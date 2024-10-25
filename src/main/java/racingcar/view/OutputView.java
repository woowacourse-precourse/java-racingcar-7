package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String MOVE_UNIT = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceStatus(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.stream().forEach(car ->
                sb.append(car.getName() + " : " + MOVE_UNIT.repeat(car.getDistance()) + "\n"));
        System.out.println(sb);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(",", winners));
    }
}
