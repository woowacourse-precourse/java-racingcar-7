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
                    // output() 메서드 사용하여 출력 결과 확인
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
    void 공백이포함된자동차이름입력_테스트() {
        assertThatThrownBy(() -> run("a, ,b", "4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백 없이 입력해주세요.");
    }

    @Test
    void 자동차이름5자초과_테스트() {
        assertThatThrownBy(() -> run("a,javaji,c", "4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차이름하나입력_테스트() {
        assertThatThrownBy(() -> run("pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("하나 이상의 자동차 이름을 입력해주세요.");
    }

    @Test
    void 시도횟수제로입력_테스트() {
        assertThatThrownBy(() -> run("a,b,c", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 숫자를 입력해주세요.");
    }

    @Test
    void 음수시도횟수입력_테스트() {
        assertThatThrownBy(() -> run("a,b,c", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 숫자를 입력해주세요.");
    }

    @Test
    void 숫자가아닌시도횟수입력_테스트() {
        assertThatThrownBy(() -> run("a,b,c", "three"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
