package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("공백 이름 테스트 ")
    public void validationEmptyNameTest() {
        //given
        String name = "";
        //expected
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("car 이름 크기 테스트")
    public void validationNameLengthTest() {
        //given
        String name1 = "test";
        String name2 = "abcdef";
        //expect
        Car car = new Car(name1);
        CarDTO carDTO = car.getCarDTO();
        assertThat(carDTO.getCarName()).isEqualTo(name1);
        assertThrows(IllegalArgumentException.class, () -> new Car(name2));
    }

    @Test
    @DisplayName("CarDTO 테스트")
    public void getCarDTOTest() {
        //given
        Car car = new Car("test");
        //when
        CarDTO carDTO = car.getCarDTO();
        //then
        assertThat(carDTO.getCarName()).isEqualTo("test");
        assertThat(carDTO.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진 테스트")
    public void advanceTest() {
        //given
        Car car = new Car("test");
        //when
        car.advance();
        CarDTO carDTO = car.getCarDTO();
        //then
        assertThat(carDTO.getPosition()).isEqualTo(1);
    }
}