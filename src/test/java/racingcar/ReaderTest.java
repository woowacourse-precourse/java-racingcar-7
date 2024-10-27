package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ReaderTest {

    @ParameterizedTest
    @CsvSource({
            "name",
            "'first,sec,third'",
            "'r car,g car,b car'"
    })
    void 올바른_이름_입력_분리_테스트(String input) {

        assertThat(Reader.splitNameInput(input))
                .isInstanceOf(List.class);
    }

    @ParameterizedTest
    @CsvSource({
            "''",
            "' '",
            "longname",
            "'hide, longn'"
    })
    void 잘못된_이름_입력_분리_테스트(String input) {

        assertThatThrownBy(() -> Reader.splitNameInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 널_입력_분리_테스트() {

        assertThatThrownBy(() -> Reader.splitNameInput(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
