package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("자동차의 이름이 5글자를 초과하는 경우 예외를 반환하는 걸 테스트하라")
    @Test
    void test1() {
        String name = "다섯글자가넘는차";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름은 쉼표(,)를 기준으로 5글자이하로만 가능합니다. 입력된 이름: (%s)", name));
    }

    @DisplayName("자동차의 이름이 null 이거나 빈 경우 예외를 반환하는 걸 테스트하라")
    @ParameterizedTest
    @NullAndEmptySource
    void test2(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름은 null 이거나 빈 칸일 수 없습니다. 입력된 이름: (%s)", name));
    }
}
