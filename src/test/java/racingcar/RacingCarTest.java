package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = RacingCar.of("woodz");
    }

    @Test
    void addSocre가_실행되면_차의_score_가_하나_증가한다() {
        // when
        racingCar.addScore();

        // then
        Assertions.assertEquals(racingCar.getScore(), 1);
    }

    @Test
    void of메소드를_통해_생성한_객체는_RacingCar_클래스의_객체이다() {
        // then
        assertThat(racingCar).isInstanceOf(RacingCar.class);
    }
}