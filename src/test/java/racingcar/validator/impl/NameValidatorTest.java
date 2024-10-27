package racingcar.validator.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class NameValidatorTest {
    NameValidator nameValidator = new NameValidator();

    @Test
    void 빈칸_입력() {
        // given
        List<String> names = new ArrayList<>();

        // when

        // then
        assertThatThrownBy(() -> nameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름을 입력해주십시오.");
    }

    @Test
    void 중복된_이름_입력() {
        // given
        List<String> names = List.of(
                "pobi",
                "pobi",
                "woni"
        );

        // when

        // then
        assertThatThrownBy(() -> nameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 입력되었습니다. 서로 다른 이름을 입력해주십시오.");
    }

    @Test
    void 글자_수_초과_입력() {
        // given
        List<String> names = List.of(
                "pobipobi",
                "pobi",
                "woni"
        );

        // when

        // then
        assertThatThrownBy(() -> nameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이하로 입력해주십시오.");
    }
}