package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @DisplayName("자동차의 name 값 정상 반환")
    @Test
    void getName() {
        //given
        Car testCar = car;
        //when
        String expectedName = "car1";
        //then
        Assertions.assertThat(testCar.getName()).isEqualTo(expectedName);
    }

    @DisplayName("자동차의 현재 위치 값 정상 반환")
    @Test
    void getCurrentPosition() {
        //given
        Car testCar = car;
        //when
        int expectedPosition = 0;
        //then
        Assertions.assertThat(testCar.getCurrentPosition()).isEqualTo(expectedPosition);
    }
}