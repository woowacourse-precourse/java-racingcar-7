package racingcar.racingapp.view;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import racingcar.racingapp.model.value.vo.CarName;
import racingcar.racingapp.model.value.vo.CarRecord;
import racingcar.racingapp.model.value.vo.RaceRecord;
import racingcar.racingapp.model.value.vo.Winners;

public class RacingOutput {

    public static void announceRaceDetails(RaceRecord raceRecord) {
        System.out.println(getProgressOnEachLap(raceRecord));

    }

    public static void announceRaceWinners(Winners winners) {
        System.out.println(getNamesOfWinners(winners));
    }

    private static String getProgressOnEachLap(RaceRecord raceRecord) {
        return raceRecord.stream()
                .map(lapRecord -> lapRecord.stream()
                        .map(RacingOutput::pairingOfNameAndProgressOfMileage)
                        .collect(bundleUpEachLap()))
                .collect(makeProgressOfEveryLap());
    }

    private static String pairingOfNameAndProgressOfMileage(CarRecord carRecord) {
        return carRecord.carName() + " : " + "-".repeat(carRecord.mileage().distance());
    }

    private static Collector<CharSequence, ?, String> bundleUpEachLap() {
        return Collectors.joining(System.lineSeparator());
    }

    private static Collector<CharSequence, ?, String> makeProgressOfEveryLap() {
        int numberOfRepeatForEmptyLine = 2;
        return Collectors.joining(
                System.lineSeparator().repeat(numberOfRepeatForEmptyLine),
                "실행 결과" + System.lineSeparator(),
                System.lineSeparator());
    }

    private static String getNamesOfWinners(Winners winners) {
        return winners.winners().carNames().stream()
                .map(CarName::name)
                .collect(Collectors.joining(",", "최종 우승자 : ", ""));
    }

}
