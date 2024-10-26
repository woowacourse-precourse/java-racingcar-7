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

    @Test
    @DisplayName("빈 문자열 검증 테스트")
    void validateEmpty() {
        String name = "짱구";
        assertThat(name).isNotEmpty();
    }

    @Test
    @DisplayName("차 이름 5자 이하 검증 테스트")
    void validateNameLength() {
        String name = "짱구짱구짱구";
        assertThrows(IllegalArgumentException.class, () -> input.validateNameLength(name));
    }

    @Test
    @DisplayName("차 이름 중복 검증 테스트")
    void validateDuplicate() {
        String name = "짱구,짱구";
        assertThrows(IllegalArgumentException.class, () -> input.validateDuplicate(name));
    }

    @Test
    @DisplayName("마지막 입력 문자열 검증 테스트")
    void validateSeparatorSplit() {
        String name = "짱구,";
        assertThrows(IllegalArgumentException.class, () -> input.validateSeparatorSplit(name));
    }
}
