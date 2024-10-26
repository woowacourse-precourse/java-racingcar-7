package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void 랜덤_숫자가_4이상인_경우_전진한다(int randomNumber) {
        // given
        CarName pobi = new CarName("pobi");
        RacingCar racingCar = new RacingCar(pobi);

        // when
        racingCar.move(randomNumber);

        // then
        assertThat(racingCar.getLocation()).isEqualTo(new RacingCar(pobi, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void 랜덤_숫자가_4미만인_경우_전진하지_않는다(int randomNumber) {
        // given
        CarName pobi = new CarName("pobi");
        RacingCar racingCar = new RacingCar(pobi);

        // when
        racingCar.move(randomNumber);

        // then
        assertThat(racingCar.getLocation()).isEqualTo(new RacingCar(pobi, 0));
    }

    @ParameterizedTest
    @CsvSource(value = {"2, true", "6, false"})
    void 위치가_같은지_확인한다(int location, boolean expected) {
        // given
        CarName pobi = new CarName("pobi");
        RacingCar racingCar = new RacingCar(pobi, 2);

        // when
        boolean actual = racingCar.isSameLocation(location);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
