package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCars;

class RacingCarGameTest {

    @DisplayName("게임에서 조건을 만족한 자동차를 한칸씩 전진시킨다.")
    @Test
    void 게임에서_조건을_만족한_자동차를_한칸씩_전진시킨다() {
        // given
        RacingCars racingCars = RacingCars.fromNames(List.of("car1", "car2"));
        RacingCarGame racingCarGame = new RacingCarGame(() -> 4);

        // when
        String executionResult = racingCarGame.execute(racingCars, 3);

        // then
        assertThat(executionResult).contains("car1 : ---", "car2 : ---");
    }

    @DisplayName("게임에서 조건을 만족하지 못하면 멈춰있는다")
    @Test
    void 게임에서_조건을_만족하지_못하면_멈춰있는다() {
        // given
        RacingCars racingCars = RacingCars.fromNames(List.of("car1", "car2"));
        RacingCarGame racingCarGame = new RacingCarGame(() -> 3);

        // when
        String executionResult = racingCarGame.execute(racingCars, 3);

        // then
        assertThat(executionResult).contains("car1 : ", "car2 :").doesNotContain("car1 : -");
    }

}