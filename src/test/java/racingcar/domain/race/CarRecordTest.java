package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarRecordTest {

    @Test
    @DisplayName("CarRecord 생성 테스트")
    void carRecordCreationTest() {
        //given
        Car car = new Car("Car1",2);

        //when
        CarRecord carRecord = CarRecord.of(car);

        //then
        assertThat(carRecord.getCarName()).isEqualTo("Car1");
        assertThat(carRecord.getDistance()).isEqualTo(2);
    }

}