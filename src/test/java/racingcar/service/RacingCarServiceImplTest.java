package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.service.RacingCarServiceImpl.getRandomMovementResult;

class RacingCarServiceImplTest {

    @Test
    @DisplayName("Service 내부 로직이 정상적으로 0 또는 1을 반환하는지 테스트")
    void RandomMovementTest(){
        int randomDistance = getRandomMovementResult();
        Assertions.assertThat(randomDistance).isIn(0, 1);
    }

}