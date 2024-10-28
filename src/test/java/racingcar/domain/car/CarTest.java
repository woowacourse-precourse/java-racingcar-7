package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

class CarTest {
    @Test
    @DisplayName("전진 여부가 True일 때 자동차의 전진거리 증가 테스트")
    void 자동차의_전진거리_증가_테스트(){
        //given
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isAllowedToAdvance() {
                return true;
            }
        };
        Car car = new Car("pobi", moveStrategy);

        //when
        int currentDistance = car.move();

        //then
        Assertions.assertThat(currentDistance).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 여부가 False일 때 자동차의 전진거리 유지 테스트")
    void 자동차의_전진거리_유지_테스트(){
        //given
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isAllowedToAdvance() {
                return false;
            }
        };
        Car car = new Car("pobi", moveStrategy);

        //when
        int currentDistance = car.move();

        //then
        Assertions.assertThat(currentDistance).isEqualTo(0);
    }
}