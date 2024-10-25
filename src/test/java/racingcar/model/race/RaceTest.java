package racingcar.model.race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.InitCars;

class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("한 턴당 출력이 작동하는지 확인한다")
    void 턴_출력_테스트() {
        Race carList = new Race(new String[]{"pobi", "woni", "jun"}, 1);
        assertRandomNumberInRangeTest(() -> {
                    assertThat(carList.turnRun()).isEqualTo("pobi : -\nwoni : \njun : -\n");
                }, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}