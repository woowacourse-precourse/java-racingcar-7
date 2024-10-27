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
        String name = "name";
        // when
        Vehicle car = new Car(name);
        // then
        Assertions.assertNotNull(car);
        Assertions.assertEquals(name, car.getName());
    }

    @Test
    void create_new_Car_when_blank_name_should_be_fail() {
        // given
        String name = "  ";
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name));
        Assertions.assertEquals("자동차 이름은 필수입니다.", ex.getMessage());
    }

    @Test
    void create_new_Car_when_exceed_length_should_be_fail() {
        // given
        String name = "car_name";
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name));
        Assertions.assertEquals("자동차 이름은 5 글자를 초과할 수 없습니다.", ex.getMessage());
    }

    @Test
    void setName_should_be_pass() {
        // given
        String name = "oname";
        Car car = new Car(name);
        // when
        String newName = "nname";
        car.setName(newName);
        // then
        Assertions.assertEquals(newName, car.getName());
    }

    @Test
    void equals_should_be_pass() {
        // given
        Vehicle car1 = new Car("cname");
        Vehicle car2 = new Car("cname");
        Vehicle car3 = new Car("oname");
        // when
        // then
        Assertions.assertEquals(car1, car2);
        Assertions.assertNotEquals(car1, car3);
        Assertions.assertNotEquals(car2, car3);
    }

    @Test
    void toString_should_be_pass() {
        // given
        String name = "cname";
        Vehicle car = new Car(name);
        // when
        String carString = car.toString();
        // then
        String expect = "Car(name=cname)";
        Assertions.assertEquals(expect, carString);
    }

    @Test
    void move_when_randomValue_is_4_should_be_pass() {
        // given
        Vehicle car = new Car("cname");
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
        Vehicle car = new Car("cname");
        // when
        AtomicBoolean isMove = new AtomicBoolean(true);
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(() -> {
            isMove.set(car.move());
        }, 3, 1);
        // then
        Assertions.assertFalse(isMove.get());
    }
}
