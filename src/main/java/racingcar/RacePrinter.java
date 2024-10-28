package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacePrinter {
    private static final String START_MESSAGE = System.lineSeparator() + "실행 결과";

    public void printWinner(List<Car> winners) {
        StringBuilder message = new StringBuilder("최종 우승자 : ");
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        message.append(String.join(", ", winnerNames));
        System.out.println(message);
    }

    public void printRace(List<Car> cars) {
        StringBuilder message = new StringBuilder();
        for (Car car : cars) {
            message.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getMoveCount()))
                    .append("\n");
        }
        System.out.println(message);
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
}
