package racingcar.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputTest {

    UserInput userInput = new UserInput();

    @Test
    void 유효한_자동차_이름_입력_테스트() {
        // given
        String input = "pobi,woni,jun";

        // when
        String[] result = userInput.readNamesOfCars(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_이름_입력이_빈_입력값일_때_예외_테스트() {
        // given시
        String input = "";

        // then
        assertThatThrownBy(() -> userInput.readNamesOfCars(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있을 수 없습니다.");
    }

    @Test
    void 자동차_이름_입력이_null_입력값일_때_예외_테스트() {
        // given
        String input = null;

        // then
        assertThatThrownBy(() -> userInput.readNamesOfCars(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있을 수 없습니다.");
    }

    @Test
    void 자동차_이름이_5글자를_초과할_경우_예외_테스트() {
        // given
        String input = "pobi,woni,jeongseho,jun";

        // then
        assertThatThrownBy(() -> userInput.readNamesOfCars(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름(\"jeongseho\")에 대한 형식이 잘못되었습니다.");
    }

    @Test
    void 시도_횟수가_양수시_성공_테스트() {
        // given
        String input = "3";

        // when
        int result = userInput.readNumberOfAttempts(input);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 시도_횟수_입력이_빈_입력값일때_예외_테스트() {
        // given
        String input = "";

        // then
        assertThatThrownBy(() -> userInput.readNumberOfAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있을 수 없습니다.");
    }

    @Test
    void 시도_횟수_입력이_null_입력값일_때_예외_테스트() {
        // given
        String input = null;

        // then
        assertThatThrownBy(() -> userInput.readNumberOfAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있을 수 없습니다.");
    }

    @Test
    void 시도_횟수_입력이_음수_입력값일_때_예외_테스트() {
        // given
        String input = "-1";

        // then
        assertThatThrownBy(() -> userInput.readNumberOfAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수(\"-1\")에 대한 형식이 잘못되었습니다.");
    }

    @Test
    void 시도_횟수_입력이_숫자가_아닌_문자열_입력일_때_예외_테스트() {
        // given
        String input = "three";

        // then
        assertThatThrownBy(() -> userInput.readNumberOfAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수(\"three\")에 대한 형식이 잘못되었습니다.");
    }

    @Test
    void 시도_횟수가_0인_경우_예외_테스트() {
        // given
        String input = "0";

        // then
        assertThatThrownBy(() -> userInput.readNumberOfAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수(\"0\")에 대한 형식이 잘못되었습니다.");
    }

}