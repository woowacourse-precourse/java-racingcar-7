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

    //입력테스트
    @Test
    void inputtest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi", "woni", "1");
                },
                MOVING_FORWARD, STOP
        );
    }

    //입력테스트  터미널은 정상 작동, 이거 메커니즘을 잘 모르겠음
    @Test
    void testcase() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains
                            (
                                    "pobi : -", "woni : ","jun : -",
                                    "pobi : --", "woni : -","jun : --",
                                    "pobi : ---", "woni : --","jun : ---",
                                    "pobi : ----", "woni : ---","jun : ----",
                                    "pobi : -----", "woni : ----","jun : -----",
                                    "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP
        );
    }
    //포함되면 맞은 것처리 하는 것으로 보임
    @Test
    void testcase_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains
                            (
                                    "pobi : -", "woni : ","jun : ",
                                    "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    //0~9의 값으로 10번 코드를 돌린 결과 (4,3,3,3,3,3,3,3,3,3)
    @Test
    void Random() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains();
                },
                MOVING_FORWARD, STOP
        );
    }

    //이름이 입력되지 않았을때 (에러)
    @Test
    void without_nameinput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //카운트가 입력되지 않았을때 (에러)
    @Test
    void without_countinput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    //,가 두 번 이상 나올시 (에러)
    @Test
    void nonamewithcomma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,coma", "23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    //이름이 5자 초과일때 (에러)
    @Test
    void over5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobiwe", "6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    //반복횟수가 1미만일때 (에러)
    @Test
    void under1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
