package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameValidatorTest {

    @Test
    @DisplayName("빈 문자열 예외")
    public void testEmptyNameString() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidator.validateNameString(List.of(""))
        );
    }

    @Test
    @DisplayName("11개 이상의 이름 예외")
    public void testCountNameString() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidator.validateNameString(List.of("1","2","3","4","5","6","7","8","9","10","11"))
        );
    }

    @Test
    @DisplayName("중복된 이름 예외")
    public void testDuplicateName() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidator.validateNameString(List.of("pobi","pobi"))
        );
    }

    @Test
    @DisplayName("비어있는 이름 예외")
    public void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidator.validateNameString(List.of("a","","b"))
        );
    }

    @Test
    @DisplayName("이름 길이가 6개 이상 예외")
    public void testLengthName() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidator.validateNameString(List.of("123456"))
        );
    }
}
