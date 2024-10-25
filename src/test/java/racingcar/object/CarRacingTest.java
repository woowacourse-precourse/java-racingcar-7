package racingcar.object;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.object.carEngine.AlwaysOnDriveCarEngine;
import racingcar.object.carEngine.BrokenCarEngine;
import racingcar.object.value.CarName;
import racingcar.object.value.RaceRecord;
import racingcar.object.value.TotalLapCount;
import racingcar.object.value.Winners;

class CarRacingTest {

    @Test
    void race_생성테스트() {
        Cars cars = new Cars(List.of(
                Car.ready(new AlwaysOnDriveCarEngine(), new CarName("씽씽이")),
                Car.ready(new BrokenCarEngine(), new CarName("폐차"))
        ));
        TotalLapCount totalLapCount = new TotalLapCount(5);
        assertThat(CarRacing.standBy(cars, totalLapCount))
                .isInstanceOf(CarRacing.class);
    }

    @Test
    void race_경기후_승자들의_이름을_얻을수있다() {
        CarName winnerName1 = new CarName("씽씽이1");
        CarName winnerName2 = new CarName("씽씽이2");
        Cars cars = new Cars(List.of(
                Car.ready(new AlwaysOnDriveCarEngine(), winnerName1),
                Car.ready(new AlwaysOnDriveCarEngine(), winnerName2),
                Car.ready(new BrokenCarEngine(), new CarName("폐차"))
        ));
        TotalLapCount totalLapCount = new TotalLapCount(5);

        CarRacing carRacing = CarRacing.standBy(cars, totalLapCount);
        RaceRecord raceRecord = carRacing.race();
        Winners winnersOfRace = raceRecord.judge();
        List<CarName> actual = winnersOfRace.winners().carNames();

        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual).containsOnly(winnerName1, winnerName2);
    }

}