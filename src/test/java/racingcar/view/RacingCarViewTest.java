package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarViewTest {

    @BeforeEach
    void setup() {
        InputStream originalIn = System.in;
    }

    @DisplayName("자동차 이름 입력 받는 테스트")
    @Test
    void givenCarNames_whenRequestCarNames_thenReturnAsList() throws Exception {
        // given
        String input = "pobi,woni,jun";
        setInput(input);
        int expected = 3;

        // when
        List<String> carNames = RacingCarView.requestCarNames();

        // then
        assertThat(carNames)
                .isNotNull()
                .hasSize(expected)
                .containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("올바른 시도 횟수 입력 받는 테스트")
    @Test
    void givenCorrectAttempts_whenRequestAttempts_thenReturnAttempts() throws Exception {
        // given
        String input = "5";
        setInput(input);
        int expected = 5;

        // when
        int actual = RacingCarView.requestAttempts();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("음수 시도 횟수 입력 시 예외 테스트")
    @Test
    void givenNegativeAttempts_whenRequestAttempts_thenThrowException() throws Exception {
        // given
        String input = "-1";
        setInput(input);

        // when & then
        assertThatThrownBy(RacingCarView::requestAttempts)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 음수일 수 없습니다.");
    }

    @DisplayName("숫자 형식이 아닌 시도 횟수 입력 시 예외 테스트")
    @Test
    void givenNotNumberAttempts_whenRequestAttempts_thenThrowException() throws Exception {
        // given
        String input = "abc";
        setInput(input);

        // when & then
        assertThatThrownBy(RacingCarView::requestAttempts)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수 값이어야합니다.");
    }

    private void setInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}