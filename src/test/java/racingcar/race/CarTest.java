package racingcar.race;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void create_new_Car_should_be_pass() {
        // given
        String name = "car_name";
        // when
        Vehicle car = new Car(name);
        // then
        Assertions.assertNotNull(car);
        Assertions.assertEquals(name, car.getName());
    }

    @Test
    void setName_should_be_pass() {
        // given
        String name = "origin_name";
        Car car = new Car(name);
        // when
        String newName = "new_name";
        car.setName(newName);
        // then
        Assertions.assertEquals(newName, car.getName());
    }

    @Test
    void equals_should_be_pass() {
        // given
        Vehicle car1 = new Car("car_name");
        Vehicle car2 = new Car("car_name");
        Vehicle car3 = new Car("other_car_name");
        // when
        // then
        Assertions.assertEquals(car1, car2);
        Assertions.assertNotEquals(car1, car3);
        Assertions.assertNotEquals(car2, car3);
    }

    @Test
    void toString_should_be_pass() {
        // given
        String name = "car_name";
        Vehicle car = new Car(name);
        // when
        String carString = car.toString();
        // then
        String expect = "Car(name=car_name)";
        Assertions.assertEquals(expect, carString);
    }

    @Test
    void move_when_randomValue_is_4_should_be_pass() {
        // given
        Vehicle car = new Car("car_name");
        // when
        AtomicBoolean isMove = new AtomicBoolean(false);
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(() -> {
            isMove.set(car.move());
        }, 4, 1);
        // then
        Assertions.assertTrue(isMove.get());
    }

    @Test
    void move_when_randomValue_is_3_should_be_pass() {
        // given
        Vehicle car = new Car("car_name");
        // when
        AtomicBoolean isMove = new AtomicBoolean(true);
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(() -> {
            isMove.set(car.move());
        }, 3, 1);
        // then
        Assertions.assertFalse(isMove.get());
    }
}
