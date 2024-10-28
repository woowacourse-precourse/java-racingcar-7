package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @ParameterizedTest
    @ValueSource(strings = {"다섯글자이상", "포르쉐카이엔"})
    public void registWithOverLength(String racingCarName) throws Exception {
        //given

        //when, then
        assertThatThrownBy(() -> {
            RacingCar newRacingCar = new RacingCar(racingCarName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"자동차,자동차 :", "레이싱카,레이싱카 :"})
    public void toString(String racingCarName, String expected) throws Exception {
        //given
        RacingCar racingCar = new RacingCar(racingCarName);

        //when
        String racingCarString = racingCar.toString();

        //then
        assertThat(racingCarString).isEqualTo(expected + " ");
    }

    @ParameterizedTest
    @CsvSource({"자동차,자동차 : -", "레이싱카,레이싱카 : -"})
    public void toStringWithMoveForward(String racingCarName, String expected) throws Exception {
        //given
        RacingCar racingCar = new RacingCar(racingCarName);
        Assertions.assertRandomNumberInRangeTest(() -> {
            racingCar.moveOrNot();
        }, MOVING_FORWARD, STOP);

        //when
        String racingCarString = racingCar.toString();

        //then
        assertThat(racingCarString).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"자동차,자동차 : ---", "레이싱카,레이싱카 : ---"})
    public void toStringWithMoveForwardThreeTimes(String racingCarName, String expected)
            throws Exception {
        //given
        RacingCar racingCar = new RacingCar(racingCarName);
        Assertions.assertRandomNumberInRangeTest(() -> {
            racingCar.moveOrNot();
            racingCar.moveOrNot();
            racingCar.moveOrNot();
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP);

        //when
        String racingCarString = racingCar.toString();

        //then
        assertThat(racingCarString).isEqualTo(expected);
    }
}