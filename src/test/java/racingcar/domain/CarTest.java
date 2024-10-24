package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.fake.ForwardNumberGenerator;
import racingcar.fake.StopNumberGenerator;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class CarTest {

    private NumberGenerator randomNumberGenerator;
    private NumberGenerator forwardNumberGenerator;
    private NumberGenerator stopNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
        forwardNumberGenerator = new ForwardNumberGenerator();
        stopNumberGenerator = new StopNumberGenerator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"붕붕붕 아주 작은 자동차", "붕붕붕 아주 큰 자동차"})
    @DisplayName("자동차 이름이 최대 범위를 초과하여 예외가 발생한다.")
    void carNameLengthTest(final String carName) throws Exception {
        //given
        //when
        //then
        assertThatThrownBy(() -> Car.of(carName, randomNumberGenerator)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("무작위 값이 기준값 미만이므로 자동차가 전진하지 않는다.")
    void stopTest() throws Exception {
        //given
        final Car car = Car.of("자동차", stopNumberGenerator);
        final long score = car.getScore();

        //when
        car.go();

        //then
        assertThat(car.getScore()).isEqualTo(score);

    }

    @Test
    @DisplayName("무작위 값이 기준값 이상이므로 자동차가 전진한다.")
    void forwardTest() throws Exception {
        //given
        final Car car = Car.of("자동차", forwardNumberGenerator);
        final long score = car.getScore();

        //when
        car.go();

        //then
        assertThat(car.getScore()).isEqualTo(score + 1);

    }

}