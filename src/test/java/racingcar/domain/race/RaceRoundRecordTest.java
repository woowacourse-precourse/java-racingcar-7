package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceRoundRecordTest {

    @Test
    @DisplayName("RaceRoundRecord 생성 테스트")
    void raceRoundRecordCreationTest() {
        //given
        Cars cars = Cars.from(List.of("Car1", "Car2"));
        cars.playOneRound(() -> true);

        //when
        RaceRoundRecord raceRoundRecord = RaceRoundRecord.from(cars);
        List<CarRecord> records = raceRoundRecord.getRaceRoundRecord();

        //then
        assertThat(records.size()).isEqualTo(2);
        assertThat(records.get(0).getCarName()).isEqualTo("Car1");
        assertThat(records.get(0).getDistance()).isEqualTo(1);
        assertThat(records.get(1).getCarName()).isEqualTo("Car2");
        assertThat(records.get(1).getDistance()).isEqualTo(1);
    }

}