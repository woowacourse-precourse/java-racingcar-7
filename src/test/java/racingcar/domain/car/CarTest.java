package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차의_이름과_위치가_정상적으로_반환된다() {
        //given
        String carName = "min";
        Car car = new Car(carName);

        //when
        CarInfo carInfo = car.getCarInfo();

        //then
        assertEquals(carName, carInfo.getName());
        assertEquals(0, carInfo.getCurrentPosition());
    }

    @Test
    void accelerate_메서드를_호출하면_자동차의_위치가_1만큼_증가한다() {
        // given
        String carName = "povi";
        Car car = new Car(carName);

        // when
        car.accelerate();
        CarInfo carInfo = car.getCarInfo();

        // then
        assertEquals(1, carInfo.getCurrentPosition());
    }

    @Test
    public void 자동차가_다른_자동차보다_앞서_있는지_확인한다() {
        //given
        Car car1 = new Car("povi");
        Car car2 = new Car("min");

        //when
        car1.accelerate();
        CarInfo carInfo1 = car1.getCarInfo();
        CarInfo carInfo2 = car2.getCarInfo();

        //then
        assertTrue(carInfo1.getCurrentPosition() > carInfo2.getCurrentPosition());
    }
}