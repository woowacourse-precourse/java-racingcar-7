package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {

    @Test
    @DisplayName("올바른 문자열 입력 시 테스트")
    void separatorStringTest() {
        Separator separator = new Separator();
        String inputString = "bob,pobi,han";
        List<String> strings = separator.separateString(inputString);

        assertEquals(3,strings.size());
    }

    @Test
    @DisplayName("문자열 공백 입력 시 테스트")
    void notValidStringInputTest() {
        Separator separator = new Separator();
        String inputString = " ";

        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () ->{
            separator.separateString(inputString);
        });

        assertThat(err.getMessage()).isEqualTo("자동차 이름이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("아무 것도 입력 하지 않을 때 테스트")
    void emptyStringInInputStringTest() {
        Separator separator = new Separator();
        String inputString = "";

        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () ->{
            separator.separateString(inputString);
        });

        assertThat(err.getMessage()).isEqualTo("자동차 이름이 입력되지 않았습니다.");
    }
}