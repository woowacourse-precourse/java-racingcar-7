package racingcar.Model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Constants.ViewMessage;

public class MessageFormatter {
    private static final String POSITION_MARKER = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    private MessageFormatter() {
    }

    public static List<String> carStates(List<Car> cars) {
        return cars.stream()
                .map(MessageFormatter::carState)
                .collect(Collectors.toList());
    }

    public static String carState(Car car) {
        return car.getName() +
                NAME_POSITION_SEPARATOR +
                POSITION_MARKER.repeat(car.getLocation());
    }

    public static String winners(List<Car> winners) {
        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_SEPARATOR));

        return ViewMessage.FINAL_WINNER_MESSAGE + result;
    }

}
