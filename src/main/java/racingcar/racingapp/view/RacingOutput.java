package racingcar.racingapp.view;

import java.util.stream.Collectors;
import racingcar.racingapp.model.value.vo.CarName;
import racingcar.racingapp.model.value.vo.RaceRecord;
import racingcar.racingapp.model.value.vo.Winners;

public class RacingOutput {

    public static void announceRaceDetails(RaceRecord raceRecord) {
        int numberOfRepeatForEmptyLine = 2;
        System.out.println(raceRecord.stream()
                .map(lapRecord -> lapRecord.stream()
                        .map(carRecord -> carRecord.carName() + " : " + "-".repeat(carRecord.mileage().distance()))
                        .collect(Collectors.joining(System.lineSeparator())))
                .collect(Collectors.joining(
                        System.lineSeparator().repeat(numberOfRepeatForEmptyLine),
                        "실행 결과" + System.lineSeparator(),
                        System.lineSeparator())));

    }

    public static void announceRaceWinners(Winners winners) {
        System.out.println(winners.winners().carNames().stream()
                .map(CarName::name)
                .collect(Collectors.joining(",", "최종 우승자 : ", "")));
    }

}
