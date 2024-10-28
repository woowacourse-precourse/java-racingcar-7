package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("우승자가 여러 명인 경우 올바르게 표시된다.")
    void 여러_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 시 콤마 앞뒤로 붙는 공백들을 무시한다.")
    void 더티_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("  abc, ave   , aef,b i , j k l,gh ,ij  ", "1");
                    assertThat(output()).contains("abc : -", "ave : ", "aef : ", "b i : ", "j k l : ", "gh : ", "ij : ", "최종 우승자 : abc, j k l");
                },
                MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("중복된 이름 발견 시 예외를 발생시킨다.")
    void 중복된_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("EP45, abc, EP45", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("(한글, 이모티콘 등) 유니코드 이름 입력 시 정상 작동한다.")
    void 유니코드_이름() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ㅣ, 가나다라마, ❤️‍🔥, 🥵💦", "1");
                    assertThat(output()).contains("ㅣ : ", "가나다라마 : -", "❤️‍🔥 : -", "🥵💦 : -", "최종 우승자 : 가나다라마, ❤️‍🔥, 🥵💦");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("숫자 대신 임의의 문자열 입력 시 예외를 발생시킨다.")
    void 숫자_대신_임의_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc, def", "💀"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우 올바르게 표시된다.")
    void 양수_아닌_정수() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("10진수가 아닌 수 입력 시 예외를 발생시킨다.")
    void 다른_진법_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc, def", "0x08"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자 앞뒤로 붙은 더티 공백은 무시한다.")
    void 숫자에_붙은_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "  1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("Null 입력 시 예외를 발생시킨다.")
    void 널_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(null, null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
