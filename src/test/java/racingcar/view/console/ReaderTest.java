package racingcar.view.console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReaderTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    @AfterEach
    void close() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n"})
    @DisplayName("빈문자열 혹은 공백이 입력되면 예외")
    void enterMessageException(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(Reader::read)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "lim,jun"})
    @DisplayName("올바른 입력값 입력")
    void enterCorrectInput(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        String value = Reader.read();

        //then
        assertThat(value).isEqualTo(input);
    }
}
