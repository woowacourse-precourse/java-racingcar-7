package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    private final Parser parser = new Parser();

    @Test
    @DisplayName("입력으로 들어오는 값을 쉼표로 분리하여 목록을 반환한다.")
    void parseCarNameTest() {
        // given
        String inputValue = "pobi,woni";
        // when
        List<String> result = parser.parseCarName(inputValue);
        // then
        assertThat(result).containsExactly("pobi", "woni");
    }

    @Test
    @DisplayName("입력으로 들어오는 값을 숫자로 변환하여 반환한다.")
    void parseGameRoundsOkTest() {
        // given
        String inputValue = "1";
        // when
        int result = parser.parseGameRounds(inputValue);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력을 숫자로 변환할 수 없으면 예외가 발생한다.")
    void parseGameRoundsExceptionTest() {
        // given
        String inputValue = "a";
        // when // then
        assertThatThrownBy(() -> parser.parseGameRounds(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다. 횟수는 숫자만 입력가능합니다.");
    }

}