package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.race.CarRecord;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceRoundRecord;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String ROUND_RESULTS_MESSAGE = "실행 결과";
    public static final String WINNER_RESULT_MESSAGE ="최종 우승자 : ";

    public void printRaceRoundResults(RaceRecord raceRecord) {

        System.out.println(ROUND_RESULTS_MESSAGE);

        for (RaceRoundRecord raceRoundRecord : raceRecord.getRaceRoundRecords()) {
            printCarRecords(raceRoundRecord);
            System.out.println();
        }
    }

    private static void printCarRecords(RaceRoundRecord raceRoundRecord) {
        for (CarRecord carRecord : raceRoundRecord.getRaceRoundRecord()) {
            System.out.println(carRecord.getCarName() + " : " + "-".repeat(carRecord.getDistance()));
        }
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerList =  winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        System.out.println(WINNER_RESULT_MESSAGE+String.join(",",winnerList));
    }
}
