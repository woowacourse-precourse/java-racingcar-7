package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {


    @Test
    @DisplayName("Car 생성 테스트 - 성공")
    void createCarTest() throws Exception {
        //given
        String input = "lgh";

        //when
        Car car = new Car(input);

        //then
        Assertions.assertThat(input).isEqualTo(car.getName());
        Assertions.assertThat(0).isEqualTo(car.getPosition());

    }

    @Test
    @DisplayName("Car 출력 테스트")
    void printCarTest() throws Exception {
        //given
        String input = "car";

        //when
        Car car = new Car(input);

        //then
        Assertions.assertThat(car.toString()).isEqualTo("car : ");


    }
}