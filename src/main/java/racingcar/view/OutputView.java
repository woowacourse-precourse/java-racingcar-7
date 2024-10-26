package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarStatus;
import racingcar.domain.race.RaceLog;
import racingcar.service.RaceResult;

public class OutputView {

    private static final String RESULT_NOTICE_MESSAGE = "실행결과";
    private static final String VICTOR_DELIMITER = ", ";

    public void printRaceResult(RaceResult raceResult) {
        printEmptyLine();
        printRaceResultNoticeMessage();
        printRaceLogs(raceResult.raceLogs());
        printVictoryCars(raceResult.victoryCars());
    }

    private void printRaceResultNoticeMessage() {
        System.out.println(RESULT_NOTICE_MESSAGE);
    }

    private void printRaceLogs(List<RaceLog> raceLogs) {
        raceLogs.forEach(raceLog -> {
            printRaceLog(raceLog);
            printEmptyLine();
        });
    }

    private void printRaceLog(RaceLog raceLog) {
        List<CarStatus> carStatuses = raceLog.getCarStatuses();
        carStatuses.forEach(carStatus -> System.out.println(createCarStatusOutput(carStatus)));
    }

    private static String createCarStatusOutput(CarStatus carStatus) {
        return carStatus.name() + " : " + "-".repeat(carStatus.position());
    }

    public void printVictoryCars(List<Car> victoryCars) {
        String result = createVictoryCarsOutput(victoryCars);
        System.out.print("최종 우승자 : " + result);
    }

    private static String createVictoryCarsOutput(List<Car> victoryCars) {
        return victoryCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(VICTOR_DELIMITER));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
