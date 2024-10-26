package racingcar.view;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


class InputViewTest {

    @Test
    void 자동차_이름_입력값_분리() {
        String input="tobi,woni,jun";
        String[] result=input.split(",");
        assertThat(result).containsExactly("tobi","woni","jun");
    }

    @Test
    void inputAttemptCount() {
    }
}