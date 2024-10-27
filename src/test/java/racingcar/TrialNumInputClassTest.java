package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrialNumInputTest {

    @Test
    void 시도횟수_정상입력_테스트() {
        setInput("3"); // 정상 입력

        int expected = 3;
        int actual = TrialNumInput.settingTrialNum();

        assertEquals(expected, actual);
    }

    @Test
    void 시도횟수_0이하입력_예외테스트() {
        setInput("-1"); // 0 이하 입력

        assertThatThrownBy(() -> TrialNumInput.settingTrialNum())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0 이상의 정수가 입력되어야 합니다. 다시 시도해주세요.");
    }

    @Test
    void 시도횟수_정수가아닌입력_예외테스트() {
        setInput("*&^-"); // 숫자가 아닌 입력

        assertThatThrownBy(() -> TrialNumInput.settingTrialNum())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 시도 횟수가 정수가 아닙니다. 다시 시도해주세요.");
    }

    // 입력을 설정하는 메소드
    private void setInput(String input) {
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
    }
}
