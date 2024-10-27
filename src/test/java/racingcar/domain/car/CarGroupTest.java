package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    private final int EXCEEDING_CAR_LIMIT = 21;

    @Test
    public void 자동차의_이름이_중복_되지_않으면_예외가_발생하지_않는다() {
        //given
        Car car1 = new Car("povi");
        Car car2 = new Car("minu");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        //when then
        assertDoesNotThrow(() -> new CarGroup(cars));
    }

    @Test
    public void 자동차의_이름이_중복_되면_예외가_발생한다() {
        //given
        Car car1 = new Car("povi");
        Car car2 = new Car("povi");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        //when then
        Assertions.assertThatThrownBy(() -> new CarGroup(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void 전진_조건이_참_일_경우_모든_자동차는_전진한다() {
        // given
        Car car1 = new Car("povi");
        Car car2 = new Car("min");
        CarGroup carGroup = new CarGroup(Arrays.asList(car1, car2));

        // when
        carGroup.accelerateCars(car -> true);

        // then
        carGroup.getCarInfos()
                .forEach(carInfo -> assertEquals(1, carInfo.getCurrentPosition()));
    }

    @Test
    public void 최대_허용_자동차_수를_초과하면_예외를_발생한다() {
        //given
        List<Car> participatingCars = new ArrayList<>();
        for (int carNumber = 1; carNumber <= EXCEEDING_CAR_LIMIT; carNumber++) {
            participatingCars.add(new Car(String.valueOf(carNumber)));
        }

        // then when
        Assertions.assertThatThrownBy(() -> new CarGroup(participatingCars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}