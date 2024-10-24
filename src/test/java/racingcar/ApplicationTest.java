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
    //TODO: 사용되는 변수들 상수화하기 (MOVING_FORWARD , STOP 처럼)

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

//TODO: 자동차 경주에서 4 이상인 값만 전진하는지 검증
    @Test
    void 자동차_전진_검증_테스트() {
        // 4 이상의 값을 입력해 자동차가 전진하는지 테스트
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -");  // 두 차 모두 전진
                },
                MOVING_FORWARD, MOVING_FORWARD  // 무작위 수가 4 이상이므로 두 차 모두 전진
        );
    }
    @Test
    void 자동차_정지_검증_테스트() {
        // 3 이하의 값을 입력해 자동차가 정지하는지 테스트
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ");  // 두 차 모두 정지
                },
                STOP, STOP  // 무작위 수가 3 이하이므로 두 차 모두 정지
        );
    }
    
    //TODO: 자동차 이름이 5자를 넘지 않는지 검증
    @Test
    void 참가자_이름_텍스트제한_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //TODO: 자동차 이름 구분에 쉼표를 사용하였는지 검증
    @Test
    void 다수참가자_구분_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni, jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //TODO: 자동차 이름이 입력되지 않을 경우 (공백)"" or null
    // 네이밍 변경 필요
    @Test
    void 자동차_이름_입력여부_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 네이밍 변경 필요
    @Test
    void 자동차_이름_입력여부_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(null, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //TODO: 자동차 게임 시도횟수가 0인 경우
    @Test
    void 자동차_게임_시도횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자동차_게임_시도횟수_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자동차_게임_시도횟수_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자동차_게임_시도횟수_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //TODO: 단독 우승자일 경우 콤마가 포함되면 안된다.
    @Test
    void 단독_우승자_출력_테스트() {
        // 4 이상 무작위 수를 입력해 pobi가 우승하는 경우, 콤마가 포함되지 않도록 테스트
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                    assertThat(output()).doesNotContain(",");  // 콤마가 포함되지 않음
                },
                MOVING_FORWARD, STOP  // pobi 전진, woni 정지
        );
    }

    @Test
    void 공동_우승자_출력_테스트() {
        // 두 명 모두 우승하는 경우, 콤마가 포함된 출력 확인
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");  // 공동 우승자 출력
                },
                MOVING_FORWARD, MOVING_FORWARD  // 두 차 모두 전진
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

