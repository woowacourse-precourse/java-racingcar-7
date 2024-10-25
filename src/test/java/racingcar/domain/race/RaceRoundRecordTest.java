package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceRoundRecordTest {

    @Test
    @DisplayName("RaceRoundRecord 생성 테스트")
    void raceRoundRecordCreationTest() {
        //given
        Car car1 = new Car("Car1",1);
        Car car2 = new Car("Car2",2);
        Cars cars = new Cars(List.of(car1,car2));

        //when
        RaceRoundRecord raceRoundRecord = RaceRoundRecord.from(cars);
        List<CarRecord> records = raceRoundRecord.getRaceRoundRecord();

        //then
        assertThat(records.size()).isEqualTo(2);
        assertThat(records.get(0).getCarName()).isEqualTo("Car1");
        assertThat(records.get(0).getDistance()).isEqualTo(1);
        assertThat(records.get(1).getCarName()).isEqualTo("Car2");
        assertThat(records.get(1).getDistance()).isEqualTo(2);
    }

}