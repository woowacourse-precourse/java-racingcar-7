package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.exception.MovementException;


class RacingCarTest {
    @Test
    void increaseDistanceBy_이동횟수1미만_예외발생(){
        // given
        RacingCar racingCar = RacingCar.create();

        // expect
        assertThatThrownBy(() -> racingCar.increaseDistanceBy(0))
                .isInstanceOf(MovementException.MinimumStepException.class)
                .hasMessage("이동 거리는 최소 1스텝 이상 가능합니다.");
    }
    @Test
    void increaseDistanceBy_이동횟수100초과_예외발생(){
        // given
        RacingCar racingCar = RacingCar.create();

        // expect
        assertThatThrownBy(() -> racingCar.increaseDistanceBy(101))
                .isInstanceOf(MovementException.MaximumStepException.class)
                .hasMessage("이동 거리는 최대 100스텝 까지만 가능합니다.");

    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,99,100})
    void increaseDistanceBy_이동횟수1포함100포함사이_예외발생안함(int count){
        // given
        RacingCar racingCar = RacingCar.create();

        // expect
        assertThatCode(() -> racingCar.increaseDistanceBy(count))
                .doesNotThrowAnyException();
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,99,100})
    void increaseDistanceBy_이동횟수1포함100포함사이_위치증가(int count){
        // given
        RacingCar racingCar = RacingCar.create();

        // when
        RacingCar movedRacingCar = racingCar.increaseDistanceBy(count);

        // then
       assertThat(movedRacingCar.provideCurrentPosition()).isEqualTo(count);
    }

    //
    @Test
    void maintainCurrentPosition_생성되고_호출시_이전위치유지() {
        // given
        RacingCar racingCar = RacingCar.create();

        // when
        RacingCar noMoveRacingCar = racingCar.maintainCurrentPosition();

        // then
        assertThat(noMoveRacingCar.provideCurrentPosition()).isEqualTo(0);
    }
    @Test
    void maintainCurrentPosition_움직이고나서_호출시_이전위치유지() {
        // given
        final int moveCount =10;

        // when
        RacingCar racingCar = RacingCar.create();
        RacingCar movedRacingCar = racingCar.increaseDistanceBy(moveCount);
        RacingCar stoppedRacingCar = movedRacingCar.maintainCurrentPosition();

        // then
        assertThat(stoppedRacingCar.provideCurrentPosition()).isEqualTo(movedRacingCar.provideCurrentPosition());
    }
    //

    @Test
    void provideCurrentPosition_초기생성_움직인거리0세팅() {
        // given
        RacingCar racingCar = RacingCar.create();

        // then
        assertThat(racingCar.provideCurrentPosition()).isEqualTo(0);
    }
    @Test
    void provideCurrentPosition_이동한후_현위치반환(){
        // given
        final int stepCount = 10;

        // when
        RacingCar racingCar = RacingCar.create();
        RacingCar movedRacingCar = racingCar.increaseDistanceBy(stepCount);

        // then
        assertThat(movedRacingCar.provideCurrentPosition()).isEqualTo(stepCount);
    }

}