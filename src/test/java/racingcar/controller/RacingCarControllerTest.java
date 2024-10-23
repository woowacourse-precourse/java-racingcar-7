package racingcar.controller;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarControllerTest {
    RacingCarController racingCarController = new RacingCarController();

    @ParameterizedTest
    @ValueSource(strings = {"1", "한글", "English"})
    void 입력_테스트(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
        String readStr = racingCarController.readLine();

        assertThat(readStr).isEqualTo(str);
    }
}