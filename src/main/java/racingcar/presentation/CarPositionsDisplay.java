package racingcar.presentation;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

// Car 도메인이 책임을 져야 하는가? 아니면 Display 클래스가 필요한가? 고민한다.
public class CarPositionsDisplay {
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_SYMBOL = "-";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final String WINNER_PREFIX = "최종 우승자 : ";

    public String formatWinnerNames(List<String> winnerNameList) {
        return WINNER_PREFIX + String.join(WINNER_NAME_SEPARATOR, winnerNameList);
    }

    public String formatPositions(Cars cars) {
        return cars.carList().stream()
                .map(this::formatSingleCarPosition)
                .collect(Collectors.joining());
    }

    private String formatSingleCarPosition(Car car) {
        return car.getName()
                + NAME_POSITION_SEPARATOR
                + POSITION_SYMBOL.repeat(car.getPosition())
                + NEW_LINE;
    }
}
