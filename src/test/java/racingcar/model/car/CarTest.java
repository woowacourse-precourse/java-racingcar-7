package racingcar.model.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.car.strategy.RandomMove;

@DisplayName("자동차의 움직임, 유효성 검사 테스트")
class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차_랜덤_숫자_임계_넘을시_이동(int randomNumber) {
        // given
        Car car = new Car(new RandomMove(), "chan");

        // when, then
        assertRandomNumberInRangeTest(() -> {
            int prevDistance = car.getMovedDistance();

            // when
            car.move();

            // then
            Assertions.assertThat(car.getMovedDistance())
                    .isEqualTo(prevDistance + 1);
        }, randomNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 자동차_랜덤_숫자_임계_미만시_정지(int randomNumber) {
        // given
        Car car = new Car(new RandomMove(), "chan");

        // when, then
        assertRandomNumberInRangeTest(() -> {
            // when
            car.move();

            // then
            Assertions.assertThat(car.getMovedDistance())
                    .isEqualTo(0);
        }, randomNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "     ", "\n"})
    public void 빈_자동차_이름_입력시_예외_발생(String carName) {
        // when, then
        Assertions.assertThatThrownBy(() -> new Car(null, carName))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "24134134", "........", "------"})
    public void 자동차_이름_5자_초과시_예외_발생(String carName) {
        // when, then
        Assertions.assertThatThrownBy(() -> new Car(null, carName))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }

    @Test
    public void 자동차_이름_NULL_예외_발생() {
        // given
        String carName = null;

        // when, then
        Assertions.assertThatThrownBy(() -> new Car(null, carName))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }
}