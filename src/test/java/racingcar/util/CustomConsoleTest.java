package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CustomConsoleTest {

    @AfterEach
    void closeConsole() {
        CustomConsole.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abc", "123", "pobi,woni"})
    void 입력된_문자열을_반환한다(String input) {
        // when
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // then
        String output = CustomConsole.readLine();

        // given
        assertThat(output).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource({"-2147483648, -2147483648", "-1, -1", "0, 0", "1, 1", "2147483647, 2147483647"})
    void 정수가_입력되면_정수를_반환한다(String input, int expected) {
        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        int output = CustomConsole.readInteger();

        // given
        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "sdf", ":", "pobi,woni", "", " ", "5+3"})
    void 정수가_아니라면_예외를_던진다(String input) {
        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        assertThatThrownBy(CustomConsole::readInteger)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
