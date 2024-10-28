package racingcar.view.console;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_REQUEST_MESSAGE = "시도할 횟수를 입력하세요.";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_MARKER = "-";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";

    @Override
    public void printCarNamesRequest() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
    }

    @Override
    public void printTryCountRequest() {
        System.out.println(TRY_COUNT_REQUEST_MESSAGE);
    }

    @Override
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formatCarPosition(car));
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<Car> winners) {
        String winnerNames = formatWinnerNames(winners);
        System.out.println(WINNER_ANNOUNCEMENT_MESSAGE + winnerNames);
    }

    private String formatCarPosition(Car car) {
        return car.getName().carName() + NAME_POSITION_SEPARATOR + POSITION_MARKER.repeat(car.getPosition().position());
    }

    private String formatWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(car -> car.getName().carName())
                .collect(Collectors.joining(", "));
    }
}
