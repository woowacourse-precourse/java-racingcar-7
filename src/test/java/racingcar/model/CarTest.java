package racingcar.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @DisplayName("car 객체 생성")
    @Nested
    class CarNameTest {
        @DisplayName("car 생성 성공")
        @Test
        public void carNameSuccess() {
            //given
            String carName = "name";
            //when
            Car car = new Car(carName);
            //Then
            assertThat(car.getName()).isEqualTo("name");

        }

        @DisplayName("car 생성시 이름 5글자 초과")
        @Test
        public void carNameException_Length() {
            //given
            String carName = "longName";
            //when && then
            assertThrows(IllegalArgumentException.class, () -> {
                new Car(carName);
            });
        }

        @DisplayName("car 생성시 이름 null")
        @Test
        public void carNameException_Null() {
            //given
            String carName = null;
            //when && then
            assertThrows(IllegalArgumentException.class, () -> {
                new Car(carName);
            });
        }

        @DisplayName("car 생성시 이름 빈칸")
        @Test
        public void carNameException_Empty() {
            //given
            String carName = "";
            //when && then
            assertThrows(IllegalArgumentException.class, () -> {
                new Car(carName);
            });
        }
    }
}
