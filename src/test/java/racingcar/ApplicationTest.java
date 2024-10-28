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
    void 중복_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 뒤_빈_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 앞_빈_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 가운데_빈_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,hello", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_비정상_알파벳_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hello", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hello", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

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
    void 글자_5자_초과_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 출력 테스트
    @Test
    void 자동차_1개_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "2");
                    assertThat(output()).contains("pobi : --");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_2개_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_3개_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hehe", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "hehe : --");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 전체_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hehe", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "hehe : --", "최종 우승자 : hehe");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hehe", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "hehe : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
