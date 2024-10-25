package racingcar.utils;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static racingcar.view.output.OutputView.RESULT_DETAIL;

public class RoundResultGenerator {
    private static final String POSITION_INDICATOR = "-";

    public static List<String> generate(List<Car> cars) {
        List<String> results = new ArrayList<>();

        for (Car car : cars) {
            results.add(formatResult(car));
        }

        return results;
    }

    private static String formatResult(Car car) {
        final String positionMarkers = generatePositionMarkers(car);

        return format(RESULT_DETAIL, car.getName(), positionMarkers);
    }

    private static String generatePositionMarkers(Car car) {
        return POSITION_INDICATOR.repeat(car.getPosition());
    }
}
