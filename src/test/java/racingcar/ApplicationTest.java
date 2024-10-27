package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // 랜덤 테스트
    @Test
    void 성공_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    // 이름 테스트

    @Test
    void 성공_기능_테스트_특수문자포함된이름() {
        assertSimpleTest(() ->
                run("\\ansd,#$%#$", "1")
        );
    }

    @Test
    void 예외_테스트_5자_넘는이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 예외_공백으로_이루어진_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("as df", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("공백은 이름에 포함될 수 없습니다.")
        );
    }

    @Test
    void 예외_중복된_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwer,qwer", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복된 이름은 사용할 수 없습니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi;jav", "pobi  woni, qwer#asdf"})
    void 예외_이상한_구분자(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {",s", "s,"})
    void 예외_구분자_사용이_잘못됨(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("쉼표(,) 구분자 사용이 틀렸습니다.")
        );
    }

    // 시도 횟수 테스트
    @Test
    void 예외_반복횟수_숫자가아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("s,v", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_횟수가_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwer,asdf", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 양의 정수여야 합니다.")
        );
    }

    @Test
    void 예외_너무많은_시도() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwer", "101"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 100번 이하로 가능합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
