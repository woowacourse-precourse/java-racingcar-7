package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 자동차가_전진하는지_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2));

        racingGame.playRound();

        assertThat(car1.getPosition()).isBetween(0, 1);
        assertThat(car2.getPosition()).isBetween(0, 1);
    }
}