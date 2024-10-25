package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarStatus;
import racingcar.domain.RaceLog;

public class OutputView {

    public void printRaceResult(List<RaceLog> raceLogs, List<Car> victoryCars) {
        System.out.println();
        printRaceResultStartMessage();
        printRaceLogs(raceLogs);
        printVictoryCars(victoryCars);
    }

    private void printRaceResultStartMessage() {
        System.out.println("실행결과");
    }

    private void printRaceLogs(List<RaceLog> raceLogs) {
        raceLogs.forEach(raceLog -> {
            List<CarStatus> carStatuses = raceLog.getCarDetails();
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
