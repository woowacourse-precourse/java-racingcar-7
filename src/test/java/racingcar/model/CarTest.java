package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("선수 생성 및 이름, 점수 가져오기")
    void getNameTest() {
        // given
        final Car car = new Car("abc");

        // when
        final String name = car.getName();
        final int score = car.getScore();

        // then
        assertEquals("abc", name);
        assertEquals(0, score);
    }

    @Test
    @DisplayName("달리기 2회 시도 2회 성공")
    void runTwiceTest() {
        // given
        final Car car = new Car("abc");

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    car.run();

                    // then
                    assertEquals(1, car.getScore());
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("달리기 2회 시도 0회 성공")
    void stopTwiceTest() {
        // given
        final Car car = new Car("abc");

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    car.run();

                    // then
                    assertEquals(0, car.getScore());
                },
                STOP, STOP
        );
    }

    @Test
    @DisplayName("달리기 2회 시도 1회 성공")
    void oneRunOneStopTest() {
        // given
        final Car car = new Car("abc");

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    car.run();

                    // then
                    assertEquals(1, car.getScore());
                },
                MOVING_FORWARD, STOP
        );
    }
}