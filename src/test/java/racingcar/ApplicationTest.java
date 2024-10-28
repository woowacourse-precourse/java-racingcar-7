package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    @DisplayName("공동 우승 테스트")
    void 공동_우승_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    @DisplayName("우승자가 없는 경우")
    void 모두_0점_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : 우승자가 없습니다.");
        }, STOP, STOP);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다라마, 바사아자차", "12345, 67890"})
    @DisplayName("예외 : 자동차 이름 5자 이상 입력")
    void 예외_테스트_자동차이름_5자_이상(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(input, "1")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("차량 이름은 5자 이하만 가능합니다."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"꼬북이", "피카츄"})
    @DisplayName("예외 : 참가 차량이 충분하지 않은 경우")
    void 예외_테스트_참가차량_부족(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(input, "1")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("경기에 참가하는 차량은 2대 이상이어야 합니다."));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "\n"})
    @DisplayName("예외 : 자동차 입력값이 잘못된 경우")
    void 예외_테스트_입력값_없음1(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(input, "1")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값이 없습니다."));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n"})
    @DisplayName("예외 : 레이싱 횟수 입력값이 잘못된 경우")
    void 예외_테스트_입력값_없음2(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("pobi,woni", input)).isInstanceOf(
                                IllegalArgumentException.class)
                        .hasMessageContaining("입력값이 없습니다."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "0.1", "1.1", "a", "1a"})
    @DisplayName("예외 : 레이스 횟수가 1 미만인 경우")
    void 예외_테스트_레이스횟수_1미만(String input) {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", input)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("레이스 횟수는 1 이상만 가능합니다."));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
