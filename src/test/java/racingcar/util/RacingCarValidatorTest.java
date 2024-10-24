package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.RacingCarValidator.validateCarDuplicate;
import static racingcar.util.RacingCarValidator.validateCarNameLength;
import static racingcar.util.RacingCarValidator.validateCountValueRange;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingCarValidatorTest {

    private NumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("자동차가 중복되어 예외가 발생한다.")
    void validateCarDuplicateTest() throws Exception {
        //given
        final List<Car> cars = List.of(
                new Car("작은 자동차", randomNumberGenerator),
                new Car("작은 자동차", randomNumberGenerator),
                new Car("큰 자동차", randomNumberGenerator)
        );

        //when
        //then
        assertThatThrownBy(() -> validateCarDuplicate(cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름의 길이가 최대 범위를 초과하여 예외가 발생한다.")
    void validateCarNameLengthTest() throws Exception {
        //given
        final String carName = "붕붕붕 아주 작은 자동차";
        final int carNameMaxLength = 5;

        //when
        //then
        assertThatThrownBy(() -> validateCarNameLength(carName, carNameMaxLength)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @Test
    @DisplayName("시도 횟수가 최대 범위를 초과하여 예외가 발생한다.")
    void validateCountValueRangeTest() throws Exception {
        //given
        final int integerCount = 10;
        final int integerMaxCount = 1;
        final long longCount = 100L;
        final long longMaxCount = 1L;

        //when
        //then
        assertAll(() -> assertThatThrownBy(() -> validateCountValueRange(integerCount, integerMaxCount)).isInstanceOf(
                        IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> validateCountValueRange(longCount, longMaxCount)).isInstanceOf(
                        IllegalArgumentException.class)
        );

    }

}