package racingcar.back.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("moveIf 매서드 동작 체크, 레이싱 페이즈가 잘 채워졌는지 확인")
    void CAR_무브_매서드_테스트() {
        //given
        Car car = new Car("hi");
        List<Integer> racePhase = List.of(1, 1, 1, 2);
        Integer moveCount = 2;

        //when
        car.moveIf(true);
        car.moveIf(false);
        car.moveIf(false);
        car.moveIf(true);

        //then
        assertThat(car.getMovePhases()).containsAll(racePhase);
        assertThat(car.getCarName()).isEqualTo("hi");
        assertThat(car.getMoveCount()).isEqualTo(moveCount);
        assertThat(car.getWinner()).isEqualTo(false);
    }

}