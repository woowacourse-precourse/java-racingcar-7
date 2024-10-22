package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommaCarNameTokenizerTest {

    @Test
    @DisplayName("입력 문자열을 받아 쉼표로 자동차 이름을 분리한다.")
    void split() {
        // given
        CommaCarNameTokenizer tokenizer = new CommaCarNameTokenizer();
        String input = "pobi,woni";

        // when
        String[] carNames = tokenizer.split(input);

        // then
        assertAll(
            () -> assertEquals(2, carNames.length),
            () -> assertEquals("pobi", carNames[0]),
            () -> assertEquals("woni", carNames[1])
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException을 던진다.")
    void splitWithOverLength() {
        // given
        CommaCarNameTokenizer tokenizer = new CommaCarNameTokenizer();
        String input = "pobi,woni,javaji";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> tokenizer.split(input));
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 IllegalArgumentException을 던진다.")
    void splitWithBlank() {
        // given
        CommaCarNameTokenizer tokenizer = new CommaCarNameTokenizer();
        String input1 = "pobi,woni, ";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> tokenizer.split(input1));

        String input2 = "pobi,,woni";
        assertThrows(IllegalArgumentException.class, () -> tokenizer.split(input2));

        String input3 = "pobi, ,woni";
        assertThrows(IllegalArgumentException.class, () -> tokenizer.split(input3));
    }
}
