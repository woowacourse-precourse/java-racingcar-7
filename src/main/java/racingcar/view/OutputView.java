package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.Race;

public class OutputView {

    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String CAR_STATUS_FORMAT = "%s : %s\n";
    private static final String WINNERS_FORMAT = "최종 우승자 : %s";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String LOCATION_SYMBOL = "-";

    public void printResultStart() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printRaceStatus(Race race) {
        List<Car> cars = race.getCars();
        cars.forEach(this::printCarStatus);
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.printf(CAR_STATUS_FORMAT, car.getName(), formatLocation(car));
    }

    private String formatLocation(Car car) {
        StringBuilder sb = new StringBuilder();
        int count = car.getLocation();
        IntStream.range(0, count).forEach(i -> sb.append(LOCATION_SYMBOL));
        return sb.toString();
    }

    public void printWinners(Race race) {
        System.out.printf(WINNERS_FORMAT, formatWinners(race));
    }

    private String formatWinners(Race race) {
        List<String> names = race.findWinners()
                .stream()
                .map(Car::getName)
                .toList();
        return String.join(WINNERS_DELIMITER, names);
    }
}
