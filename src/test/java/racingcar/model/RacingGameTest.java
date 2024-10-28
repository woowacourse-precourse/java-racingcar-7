package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("성공 : 최종 우승자가 올바르게 판별된다")
    @Test
    void 최종_우승자_판별_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        car1.move(5);
        car1.move(6);
        car2.move(4);

        RacingGame game = new RacingGame(List.of(car1, car2));
        List<String> winners = game.getWinners();

        assertThat(winners).containsExactly("pobi");
    }

    @DisplayName("성공 : 공동 우승자 판별 테스트")
    @Test
    void 공동_우승자_판별_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        car1.move(5);
        car2.move(5);

        RacingGame game = new RacingGame(List.of(car1, car2));
        List<String> winners = game.getWinners();

        assertThat(winners).containsExactly("pobi", "woni");
    }
}
