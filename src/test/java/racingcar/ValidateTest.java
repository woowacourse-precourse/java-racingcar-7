package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import org.junit.jupiter.api.Test;

class ValidateTest {
    @Test
    void 자동차_이름_길이_검사() {
        assertThatThrownBy(() -> Validate.validateCarNameLength("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_중복_검사() {
        assertThatThrownBy(() -> Validate.validateDuplicateName(List.of("pobi", "pobi", "jun")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 최소_자동차_수_검사() {
        assertThatThrownBy(() -> Validate.validateCarsCount(List.of("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 2대 이상이어야 합니다.");
    }

    @Test
    void 빈_자동차_이름_검사() {
        assertThatThrownBy(() -> Validate.validateCarNameIsEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 값일 수 없습니다.");
    }

    @Test
    void 게임_횟수_검사() {
        assertThatThrownBy(() -> Validate.validateGameCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수는 1 이상이어야 합니다.");
    }
}