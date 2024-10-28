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

    // 1단계: 자동차 이름 입력 기능 테스트
    @Test
    void 자동차이름_정상입력_테스트() {
        assertSimpleTest(() -> {
            run("pobi,woni", "5");
            assertThat(Application.carNames).containsExactly("pobi", "woni");
        });
    }

    @Test
    void 자동차이름_길이초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    // 2단계: 이동 횟수 입력 기능 테스트
    @Test
    void 이동횟수_정상입력_테스트() {
        assertSimpleTest(() -> {
            run("pobi,woni", "5");
            assertThat(Application.tryCount).isEqualTo(5);
        });
    }

    @Test
    void 이동횟수_음수입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이동 횟수는 양의 정수여야 합니다.")
        );
    }

    // 3단계: 자동차 경주 진행 기능 테스트
    @Test
    void 자동차경주_진행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
