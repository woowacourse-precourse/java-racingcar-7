package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void beforeEach() {
        parser = new Parser();
    }

    @Test
    @DisplayName("자동차 이름을 파싱하여 리스트로 반환하는 테스트")
    void parseCarNames() {
        // given
        String carNamesInput = "pobi, woni, jun";

        // when
        List<String> carNames = parser.parseCarNames(carNamesInput);

        // then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("문자열을 정수로 변환하는 테스트")
    void convertStringToBigInteger() {
        // given
        String input = "5";

        // when
        BigInteger bigInteger = parser.convertStringToBigInteger(input);

        // then
        assertThat(bigInteger).isEqualTo(5);
    }

    @Test
    @DisplayName("문자열을 정수로 변환하는 테스트: 숫자가 아닌 값 - 예외 테스트")
    void convertStringToBigInteger_nonNumeric() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> parser.convertStringToBigInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("리스트를 구분자로 연결하여 문자열로 반환하는 테스트")
    void joinWithJoiner() {
        // given
        List<String> names = Arrays.asList("pobi", "woni", "jun");

        // when
        String result = parser.joinWithJoiner(names, ", ");

        // then
        assertThat(result).isEqualTo("pobi, woni, jun");
    }
}