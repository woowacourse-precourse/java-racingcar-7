package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RaceLog;
import racingcar.model.RacerProgress;

public class OutputView {
    private static final String PRINT_LOG_PROMPT = "\n실행 결과";
    private static final String PRINT_WINNER_PREFIX = "최종 우승자 : ";

    private OutputView() {}

    private static class Holder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return Holder.INSTANCE;
    }

    public void printRaceLogs(List<RaceLog> raceLogs) {
        System.out.println(PRINT_LOG_PROMPT);
        raceLogs.forEach(this::printRaceLog);
    }

    private void printRaceLog(RaceLog raceLog) {
        raceLog.getRacerProgresses()
                .stream()
                .map(RacerProgress::generateString)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printRaceWinners(List<Car> cars) {
        System.out.println(PRINT_WINNER_PREFIX + cars
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
    }
}
