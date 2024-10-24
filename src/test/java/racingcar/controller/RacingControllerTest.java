package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.StringSplitter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {

    private StringSplitter stringSplitter;

    @BeforeEach
    void setUp() {
        this.stringSplitter = new StringSplitter();
    }

    @Test
    void run() {
        /* Given */
        String input = "녹차,말차,유자차";
        /* When */
        List<String> inputList = stringSplitter.split(input);
        /* Then */
        assertThat(inputList).containsExactly("녹차", "말차", "유자차");
    }
}