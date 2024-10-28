package racingcar.domain;

import java.lang.reflect.Field;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.vo.ExceptionMessage;

public class CarTest {

    @Test
    void 자동차_이름_길이가_5를_넘으면_IllegalArgumentException_발생() {
        String name = "jinjin";
        Assertions.assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class).hasMessage(
                ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    void 랜덤_숫자가_4이상_나오면_앞으로_이동() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car("jin");

        car.moveIfPossible(4);

        Field field = car.getClass().getDeclaredField("moveCount");
        field.setAccessible(true);

        int result = (int) field.get(car);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 랜덤_숫자가_4미만_나오면_제자리() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car("jin");

        car.moveIfPossible(3);

        Field field = car.getClass().getDeclaredField("moveCount");
        field.setAccessible(true);

        int result = (int) field.get(car);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
