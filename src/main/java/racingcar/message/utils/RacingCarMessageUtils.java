package racingcar.message.utils;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

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

    public static String carsResultMessage(RacingCars racingCars) {
        StringBuilder stringBuilder = new StringBuilder();

        racingCars.getCars()
                .stream()
                .map(RacingCarMessageUtils::carNamePositionMessage)
                .forEach(message -> appendLine(stringBuilder, message));

        appendLine(stringBuilder);

        return stringBuilder.toString();
    }

    private static void appendLine(StringBuilder stringBuilder, String message) {
        stringBuilder.append(message).append("\n");
    }

    private static void appendLine(StringBuilder stringBuilder) {
        appendLine(stringBuilder, "");
    }
}
