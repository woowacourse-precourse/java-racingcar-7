package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.car.Car;
import domain.car.Cars;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.enums.ErrorMessage;

class CarsTest {

    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        car1 = Car.from("pobi");
        car2 = Car.from("woni");
        car3 = Car.from("jun");
    }

    @Nested
    class Cars_생성_테스트 {

        @Test
        void 유효한_자동차_리스트로_Cars_객체를_생성할_수_있다() {
            // given
            List<Car> carList = List.of(car1, car2, car3);

            // when
            Cars cars = Cars.from(carList);

            // then
            assertEquals(3, cars.size());
        }

        @Test
        void 중복된_이름의_자동차가_있으면_Cars_객체를_생성할_수_없다() {
            // given
            Car duplicateCar = Car.from("pobi");
            List<Car> carList = Arrays.asList(car1, duplicateCar, car2);

            // when & then
            assertThatThrownBy(() -> Cars.from(carList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

}