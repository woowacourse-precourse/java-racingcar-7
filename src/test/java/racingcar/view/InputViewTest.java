package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    private void command(String... args) {
        String input = String.join(",", args);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void tearDown() {
        Console.close(); // 각 테스트 이후 Scanner 초기화
    }

    @ParameterizedTest
    @CsvSource({
            "'car,hi,asdf,lll'",
            "'abc,a,b,c'",
            "'aaaa,abcd,abcd,kore,asdf'",
            "'abcde,qwert,qewss,poiuy'"
    })
    void testGetCarNames(String input) {
        // Given
        this.command(input);
        String[] expectedCarNames = input.split(",");

        // When
        List<String> carNames = InputView.getCarNames();

        // Then
        assertThat(carNames).containsExactly(expectedCarNames);
        assertThat(carNames).hasSize(expectedCarNames.length);
    }
}