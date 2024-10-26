package racingcar.message.utils;

import racingcar.domain.RacingCar;

import java.util.LinkedHashSet;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static racingcar.message.RacingMessage.*;

public class CarPositionMessageUtils {

    public static String generateCarsPositionMessage(LinkedHashSet<RacingCar> cars) {
        StringBuilder builder = new StringBuilder();

        cars.stream()
                .map(CarPositionMessageUtils::generateCarPositionMessage)
                .forEach(message -> appendLineWithMessage(builder, message));

        return builder.toString();
    }

    private static String generateCarPositionMessage(RacingCar car) {
        return CAR_POSITION.getFormatMessage(car.getName(), convertSymbolByPosition(car.getPosition()));
    }

    private static String convertSymbolByPosition(int position) {
        return range(0, position)
                .mapToObj(i -> CAR_POSITION_SYMBOL)
                .collect(joining());
    }

    private static void appendLineWithMessage(StringBuilder builder, String message) {
        builder.append(message).append(NEW_LINE);
    }
}
