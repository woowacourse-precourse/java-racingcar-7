package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarStatus;
import racingcar.domain.race.RaceLog;
import racingcar.service.RaceResult;

public class OutputView {

    public void printRaceResult(RaceResult raceResult) {
        System.out.println();
        printRaceResultStartMessage();
        printRaceLogs(raceResult.raceLogs());
        printVictoryCars(raceResult.victoryCars());
    }

    private void printRaceResultStartMessage() {
        System.out.println("실행결과");
    }

    private void printRaceLogs(List<RaceLog> raceLogs) {
        raceLogs.forEach(raceLog -> {
            List<CarStatus> carStatuses = raceLog.getCarStatuses();
            carStatuses.forEach(carStatus -> {
                StringBuilder sb = new StringBuilder(carStatus.name() + " : ");
                int distance = carStatus.position();
                while (distance-- > 0) {
                    sb.append("-");
                }
                System.out.println(sb);
            });
            System.out.println();
        });
    }

    public void printVictoryCars(List<Car> victoryCars) {
        String result = victoryCars.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + result);
    }
}
