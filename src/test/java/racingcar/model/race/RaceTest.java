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
        Race race = new Race(new String[]{"pobi", "woni", "jun"}, 1);
        assertRandomNumberInRangeTest(() -> {
                    assertThat(race.turnRun()).isEqualTo("pobi : -\nwoni : \njun : -\n");
                }, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("raceRun을 실행했을때 반환값 확인한다")
    void 레이스_실행_테스트() {
        Race race = new Race(new String[]{"pobi", "woni"}, 2);
        assertRandomNumberInRangeTest(() -> {
                    assertThat(race.raceRun()).isEqualTo("pobi : -\nwoni : \n\npobi : --\nwoni : -\n");
                }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("Winner가 제대로 구해지는지 확인한다")
    void 우승자_테스트() {
        Race race = new Race(new String[]{"pobi", "woni", "jun"}, 3);
        assertRandomNumberInRangeTest(() -> {
                    race.raceRun();
                    assertThat(race.getWinners()).containsExactly("pobi", "woni");
                }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP
        );
    }
}