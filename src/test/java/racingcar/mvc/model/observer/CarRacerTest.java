package racingcar.mvc.model.observer;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacerTest {
    CarRacer carRacer;

    @BeforeEach
    void setUp() {
        carRacer = new CarRacer("pobi");
    }

    @Test
    @DisplayName("스탑 한 번")
    void test1() {
        final int STOP = 2;

        assertRandomNumberInRangeTest(
                () -> {
                    carRacer.update();
                    assertThat(carRacer.toString()).isEqualTo("pobi : ");
                },
                STOP
        );
    }

    @Test
    @DisplayName("스탑 한 번 + 전진 두 번")
    void test2() {
        final int STOP = 2;
        final int MOVING_FORWARD = 6;

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        carRacer.update();
                    }
                    assertThat(carRacer.toString()).isEqualTo("pobi : --");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("전진 한 번")
    void test3() {
        final int MOVING_FORWARD = 6;

        assertRandomNumberInRangeTest(
                () -> {
                    carRacer.update();
                    assertThat(carRacer.toString()).isEqualTo("pobi : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("전진 한 번 + 스탑 한 번 + 전진 두 번")
    void test4() {
        final int STOP = 2;
        final int MOVING_FORWARD = 6;

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        carRacer.update();
                    }
                    assertThat(carRacer.toString()).isEqualTo("pobi : --");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}