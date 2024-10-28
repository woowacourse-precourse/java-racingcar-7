package racingcar.controller.validation;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.view.messages.ErrorMessageEnum;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NameValidatorTest {

    private final NameValidator validator = new NameValidator();

    @Test
    void 유효값_통과_테스트() { // TODO: 리팩토링 이후 수
        List<String> names = List.of("pobi", "woni");
        int result = validator.validate(names);
        assertEquals(1, result);
    }

    @Test
    void 공백_테스트() {
        List<String> names = List.of("");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(names);
        });
        assertEquals(ErrorMessageEnum.EMPTY_ERROR.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 이름_길이_테스트() {
        List<String> names = List.of("pobi", "javaji");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(names);
        });
        assertEquals(ErrorMessageEnum.NAME_LENGTH_ERROR.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 중복_이름_테스트() {
        List<String> names = List.of("pobi", "pobi");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(names);
        });
        assertEquals(ErrorMessageEnum.DUPLICATE_NAMES_ERROR.getErrorMessage(), exception.getMessage());
    }
}