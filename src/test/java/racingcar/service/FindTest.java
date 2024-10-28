package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.collection.RacingCar;

// 게임 이후 우승자를 가리는 기능 테스트
class FindTest {

    private static final Find find = new Find();
    private static RacingCar racingCar;

    @BeforeAll
    static void setUp() {
        racingCar = new RacingCar("a,b,c");

        racingCar.moveForward("a");
        racingCar.moveForward("a");
        racingCar.moveForward("b");
    }

    @Test
    @DisplayName("가장 먼 이동 거리를 찾는 기능 테스트")
    void 가장_먼_거리() {
        Assertions.assertThat(find.FurthestNumber(racingCar))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("가장 먼 거리를 이동한 우승 레이싱 카를 찾는 기능 테스트")
    void 우승자_탐색() {
        Assertions.assertThat(find.Winners(racingCar, 2))
                .contains("a");
    }
}