package racingcar;

import static org.assertj.core.api.Assertions.catchException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GasolineCarTest {

    Engine engine;
    int moveDistance = 10;

    @BeforeEach
    void initGasoline() {
        engine = new Gasoline(moveDistance);
    }

    @Test
    void 차이름은_5자를_넘을_수_없다() {
        //given

        //when
        Exception exception = catchException(() -> {
            new Car("여섯글자이름", engine);
        });

        //then
        Assertions.assertThat(exception).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Car.INVALID_CAR_NAME);
    }

    @Test
    void 가솔린차는_페달을_밟을때마다_전진한다() {
        //given
        Vehicle car = new Car("k5", engine);

        //when
        int distance = car.pushPedal();

        //then
        Assertions.assertThat(distance).isEqualTo(moveDistance);
    }
}
