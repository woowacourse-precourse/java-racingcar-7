package racingcar.message.utils;

import racingcar.domain.RacingCar;

import java.util.LinkedList;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static racingcar.message.RacingMessage.CAR_NAME_POSITION;

public class RacingCarMessageUtils {

    public final static String CAR_POSITION_SYMBOL = "-";

    public static String convertSymbolByPosition(int position) {
        return range(0, position)
                .mapToObj(i -> CAR_POSITION_SYMBOL)
                .collect(joining());
    }

    public static String carNamePositionMessage(RacingCar car) {
        return CAR_NAME_POSITION.getFormatMessage(car.getName(), convertSymbolByPosition(car.getPosition()));
    }

    public static String carsResultMessage(LinkedList<RacingCar> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        cars.stream()
                .map(RacingCarMessageUtils::carNamePositionMessage)
                .forEach(message -> appendLine(stringBuilder, message));

        appendLine(stringBuilder);

        return stringBuilder.toString();
    }

    private static void appendLine(StringBuilder stringBuilder) {
        appendLine(stringBuilder, "");
    }

    private static void appendLine(StringBuilder stringBuilder, String message) {
        stringBuilder.append(message).append("\n");
    }
}
