package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 자동차이름_정상입력_테스트() {
        // 정상적인 자동차 이름 입력과 이동 횟수 입력
        assertSimpleTest(() -> {
            run("pobi,woni", "5"); // 자동차 이름과 이동 횟수 입력값 제공
            assertThat(Application.carNames).containsExactly("pobi", "woni");
        });
    }

    @Test
    void 자동차이름_길이초과_예외_테스트() {
        // 자동차 이름이 5자를 초과할 때 예외 발생 여부 확인
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "5")) // 예외 발생을 위한 입력값
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
