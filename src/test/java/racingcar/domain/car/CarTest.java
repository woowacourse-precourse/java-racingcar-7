package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.exception.BusinessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    private final static int MOVABLE_VALUE = 4;
    private final static int IMMOVABLE_VALUE = 3;
    private final static int NUMBER_OUT_OF_RANGE = 10;

    @Test
    void Car_생성_테스트() {
        // given
        Car car = new Car("pobi");

        // when, then
        assertAll(
            () -> assertThat(car).isNotNull(),
            () -> assertThat(car.getPosition()).isEqualTo(0)
        );
    }

    @Test
    void 차가_이동하면_position_1증가() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(MOVABLE_VALUE);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 차가_정지하면_position_정지() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(IMMOVABLE_VALUE);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 허용되지_않는_값을_입력한_경우_BusinessException() {
        // given
        Car car = new Car("pobi");

        // when & then
        assertThatThrownBy(() -> {
            car.move(NUMBER_OUT_OF_RANGE);
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 차가_이동하면_position_1증가_여러번_시도() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(MOVABLE_VALUE);
        car.move(IMMOVABLE_VALUE);
        car.move(MOVABLE_VALUE);
        car.move(IMMOVABLE_VALUE);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차_이름이_5자_이상인_경우_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new Car("ExceptionName");
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 자동차_이름이_빈문자인_경우_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 자동차_이름이_null인_경우_BusinessException() {
        // given & when & then
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
