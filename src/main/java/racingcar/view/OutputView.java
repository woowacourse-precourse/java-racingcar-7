package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarDetail;
import racingcar.domain.RaceLog;

public class OutputView {

    public void printRaceResult(List<RaceLog> raceLogs, List<CarDetail> victoryCarDetails) {
        System.out.println();
        printRaceResultStartMessage();
        printRaceLogs(raceLogs);
        System.out.println();
        printVictoryCars(victoryCarDetails);
    }

    private void printRaceResultStartMessage() {
        System.out.println("실행결과");
    }

    private void printRaceLogs(List<RaceLog> raceLogs) {
        raceLogs.forEach(raceLog -> {
            List<CarDetail> carDetails = raceLog.getCarDetails();
            carDetails.forEach(carDetail -> {
                StringBuilder sb = new StringBuilder(carDetail.name() + " : ");
                int distance = carDetail.distance();
                while (distance-- > 0) {
                    sb.append("-");
                }
                System.out.println(sb);
            });
            System.out.println();
        });
    }

    public void printVictoryCars(List<CarDetail> victoryCarDetails) {
        String result = victoryCarDetails.stream().map(CarDetail::name).collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + result);
    }
}
