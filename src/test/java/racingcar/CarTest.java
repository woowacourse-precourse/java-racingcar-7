package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 자동차_이름_주행거리_초기화_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = new Car(carName);

        //When
        String actualName = car.getName();
        int actualMileage = car.getMileage();

        //Then
        Assertions.assertThat(actualName).isEqualTo(carName);
        Assertions.assertThat(actualMileage).isEqualTo(0);
    }
}