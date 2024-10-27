package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarStatus;
import racingcar.domain.race.RaceLog;
import racingcar.service.RaceResult;

public class OutputView {

    private static final String RESULT_NOTICE_MESSAGE = "실행 결과";
    private static final String CAR_STATUS_OUTPUT_FORMAT = "%s : %s";
    private static final String CAR_POSITION_BAR = "-";
    private static final String VICTOR_DELIMITER = ", ";
    private static final String RACE_RESULT_FORMAT = "최종 우승자 : %s";

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

    private String createCarStatusOutput(CarStatus carStatus) {
        return String.format(CAR_STATUS_OUTPUT_FORMAT, carStatus.name(), CAR_POSITION_BAR.repeat(carStatus.position()));
    }

    public void printVictoryCars(List<Car> victoryCars) {
        String result = createVictoryCarsOutput(victoryCars);
        System.out.printf(RACE_RESULT_FORMAT, result);
    }

    private String createVictoryCarsOutput(List<Car> victoryCars) {
        return victoryCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(VICTOR_DELIMITER));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
