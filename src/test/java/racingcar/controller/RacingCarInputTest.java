package racingcar.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarInputTest {
    RacingCarInput racingCarInput = new RacingCarInput();

    @ParameterizedTest
    @ValueSource(strings = {"1,2\n2", "한글\n3", "Engl,ish\n4"})
    void 입력_테스트(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
        List<String> readStr = racingCarInput.getUserInput();

        assertThat(readStr).isEqualTo(List.of(str.split("\n")));
    }
}