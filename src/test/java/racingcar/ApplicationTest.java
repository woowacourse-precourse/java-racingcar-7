package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_길이_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javajava", "1")) // "javajava"는 6자 이상
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_등록_테스트() {
        assertSimpleTest(() -> {
            run("car1,car2,car3", "2");
            assertThat(output()).contains("car1 : ", "car2 : ", "car3 : ");
        });
    }

    @Test
    void 경주_진행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2", "5");
                    assertThat(output()).contains("car1 : ", "car2 : ");
                },
                MOVING_FORWARD, STOP
        );
    }

//    @Test
//    void 여러_우승자_테스트() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("car1,car2", "3");
//                    assertThat(output()).contains("최종 우승자 : car1, car2");
//                },
//                MOVING_FORWARD, STOP
//        );
//    }

    @Test
    void 단독_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2", "3");
                    assertThat(output()).contains("최종 우승자 : car1");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
