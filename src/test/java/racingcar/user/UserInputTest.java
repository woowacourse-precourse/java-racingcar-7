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
    void 빈_입력값_실패_테스트() {
        // given
        String input = "";

        // then
        assertThatThrownBy(() -> userInput.readNamesOfCars(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있을 수 없습니다.");
    }

    @Test
    void null_입력값_실패_테스트() {
        // given
        String input = null;

        // then
        assertThatThrownBy(() -> userInput.readNamesOfCars(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 비어있을 수 없습니다.");
    }

    @Test
    void 자동차_이름이_5글자를_초과할_경우_실패_테스트() {
        // given
        String input = "pobi,woni,jeongseho,jun";

        // then
        assertThatThrownBy(() -> userInput.readNamesOfCars(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름(\"jeongseho\")에 대한 형식이 잘못되었습니다.");
    }

}