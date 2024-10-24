package racingcar.object;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.object.carEngine.AlwaysOnDriveCarEngine;
import racingcar.object.carEngine.BrokenCarEngine;
import racingcar.object.value.CarName;
import racingcar.object.value.LapRecord;
import racingcar.object.value.Mileage;

class LapTest {

    @Test
    void doLap으로_랩을수행하고_랩의결과를받는다() {
        Lap lap = new Lap(List.of(
                Car.ready(new AlwaysOnDriveCarEngine(), new CarName("1번씽씽이")),
                Car.ready(new BrokenCarEngine(), new CarName("2번폐차"))));

        // 씽씽이는 두번 모두 달리고, 폐차는 두번 모두 서있는다
        LapRecord firstLapRecord = lap.doLap();
        LapRecord secondLapRecord = lap.doLap();

        // 랩-기록의 결과는 CarName 오름차순이다
        // firstLap
        assertThat(firstLapRecord.carRecords().get(0).mileage())
                .isEqualTo(new Mileage(1));
        assertThat(firstLapRecord.carRecords().get(1).mileage())
                .isEqualTo(new Mileage(0));
        // secondLap
        assertThat(secondLapRecord.carRecords().get(0).mileage())
                .isEqualTo(new Mileage(2));
        assertThat(secondLapRecord.carRecords().get(1).mileage())
                .isEqualTo(new Mileage(0));
    }

}