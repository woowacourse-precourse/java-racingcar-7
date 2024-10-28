package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("자동차_이름이_5글자_초과_시_예외_발생")
    @Test
    void validateName() {
        String name = "pobbii";
        assertThatThrownBy(() -> new RacingCar(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차_이름이_정상일_때_자동차_생성")
    @Test
    void createRacingCar() {
        //given
        String name = "pobi";
        //when
        RacingCar racingCar = new RacingCar(name);
        //then
        assertThat(racingCar.getName()).isEqualTo(name);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("이동_전략이_참이_되었을때_전진한다")
    @Test
    void checkMoveForwardTrueAndMove() {
        //given
        MoveStrategy moveStrategy = () -> true;
        //when
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.checkMoveForwardAndMove(moveStrategy);
        //then
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동_전략이_거짓이_되었을때_전진하지_않는다")
    @Test
    void checkMoveForwardFalseAndStop() {
        //given
        MoveStrategy moveStrategy = () -> false;
        //when
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.checkMoveForwardAndMove(moveStrategy);
        //then
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

}