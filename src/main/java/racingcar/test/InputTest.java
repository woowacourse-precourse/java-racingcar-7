package racingcar.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import racingcar.Input;

public class InputTest {
    Input input;
    @BeforeEach
    public void setUp() {
        input = new Input();
    }

    @Test
    @DisplayName("공백이 포함된 문자열 검증 테스트")
    void validateBlank() {
        String name = "짱구, 포비,준";
        assertThrows(IllegalArgumentException.class, () -> input.validateBlank(name));
    }
}
