package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Participants;

public class OutputView {
    private static final String ROUND_RESULT_START_MESSAGE = "실행 결과";

    private final StringBuilder stringBuilder = new StringBuilder();

    public void initPrintRoundResult() {
        System.out.println(ROUND_RESULT_START_MESSAGE);
    }

    public void printWinners(List<Car> winners) {
        String winCarNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winCarNames);
    }

    public void printRoundResult(Participants participants) {
        List<Car> cars = participants.getParticipants();
        for (Car car : cars) {
            String distanceGraph = buildDistanceGraph(car.getMovedDistance());
            System.out.printf("%s : %s\n", car.getName(), distanceGraph);
        }
        System.out.println();
    }

    private String buildDistanceGraph(int distance) {
        clearStringBuilder();
        while (distance > 0) {
            stringBuilder.append("-");
            distance--;
        }
        return stringBuilder.toString();
    }

    private void clearStringBuilder() {
        if (!stringBuilder.isEmpty()) {
            stringBuilder.delete(0, stringBuilder.length());
        }
    }
}
