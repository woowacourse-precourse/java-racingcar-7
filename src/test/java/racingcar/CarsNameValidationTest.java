package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsNameValidationTest {

    @Test
    @DisplayName("빈 문자열이 입력된 경우 예외 발생")
    void testEmptyInput() {
        List<String> input = List.of("");
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validate(input));
    }

    @Test
    @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
    void testNameExceedsFiveCharacters() {
        List<String> input = List.of("pobi", "woni", "abcdefgh");
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validate(input));
    }

    @Test
    @DisplayName("중복된 이름이 입력된 경우 예외 발생")
    void testDuplicateNames() {
        List<String> input = List.of("pobi", "woni", "pobi");
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validate(input));
    }

    @Test
    @DisplayName("빈 이름이 포함된 경우 예외 발생")
    void testContainsEmptyName() {
        List<String> input = List.of("pobi", "", "jun");
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validate(input));
    }

    @Test
    @DisplayName("정상적인 이름 목록이 입력된 경우 반환된 값이 일치하는지 확인")
    void testValidNamesInput() {
        List<String> input = List.of("pobi", "woni", "jun");
        CarNameValidator.validate(input);  // 예외가 발생하지 않음을 검증
        assertEquals(input, List.of("pobi", "woni", "jun"));
    }
}
