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
    void 자동차_전진_및_정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "jun : -",
                            "",
                            "pobi : --",
                            "woni : ",
                            "jun : --",
                            "",
                            "pobi : ---",
                            "woni : ",
                            "jun : ---",
                            "",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_관리_정상_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("anna,ben", "2");
                    assertThat(output()).contains(
                            "anna : -",
                            "ben : -",
                            "",
                            "anna : --",
                            "ben : --",
                            "",
                            "최종 우승자 : anna, ben"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_길이초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.")
        );
    }

    @Test
    void 시도횟수_비정수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "three"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 정수여야 합니다.")
        );
    }

    @Test
    void 시도횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "-5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 양의 정수여야 합니다.")
        );
    }

    @Test
    void 단독_우승자_결정_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "jun : ",
                            "",
                            "pobi : --",
                            "woni : ",
                            "jun : ",
                            "",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 공동_우승자_결정_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("alice,bob,charl", "1");
                    assertThat(output()).contains(
                            "alice : -",
                            "bob : -",
                            "charl : -",
                            "",
                            "최종 우승자 : alice, bob, charl"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
