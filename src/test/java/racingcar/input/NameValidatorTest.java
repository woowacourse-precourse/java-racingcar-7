package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorCode;

class NameValidatorTest {

    @Test
    void 유효한_이름은_예외가_발생하지_않는다() throws NoSuchFieldException, IllegalAccessException {
        // given
        int maxNameLength = getMaxNameLength();
        String validName = "a".repeat(maxNameLength);

        // when & then
        assertThatCode(() -> NameValidator.validate(validName))
                .doesNotThrowAnyException();
    }

    @Test
    void 유효하지_않은_이름은_예외가_발생한다() throws NoSuchFieldException, IllegalAccessException {
        // given
        int minNameLength = getMinNameLength();
        int maxNameLength = getMaxNameLength();

        String expectedMessage = ErrorCode.INVALID_CAR_NAME.getMessage(minNameLength, maxNameLength);

        String tooLongName = "a".repeat(maxNameLength + 1);
        String tooShortName = "a".repeat(Math.max(0, minNameLength - 1));

        // when & then
        assertThatThrownBy(() -> NameValidator.validate(tooLongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);

        assertThatThrownBy(() -> NameValidator.validate(tooShortName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    void 유효한_이름_리스트는_예외가_발생하지_않는다() {
        // given
        List<String> validNames = List.of("car1", "car2", "car3");

        // when & then
        assertThatCode(() -> NameValidator.validate(validNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 유효하지_않은_이름_리스트는_예외가_발생한다() throws NoSuchFieldException, IllegalAccessException {
        // given
        int minNameLength = getMinNameLength();
        int maxNameLength = getMaxNameLength();

        String expectedMessage = ErrorCode.INVALID_CAR_NAME.getMessage(minNameLength, maxNameLength);

        String tooLongName = "a".repeat(maxNameLength + 1);
        String tooShortName = "a".repeat(Math.max(0, minNameLength - 1));

        List<String> invalidNames = List.of("car1", tooLongName, tooShortName);

        // when & then
        assertThatThrownBy(() -> NameValidator.validate(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private int getMinNameLength() throws NoSuchFieldException, IllegalAccessException {
        Field minNameLengthField = NameValidator.class.getDeclaredField("MIN_NAME_LENGTH");
        minNameLengthField.setAccessible(true);
        return (int) minNameLengthField.get(null);
    }

    private int getMaxNameLength() throws NoSuchFieldException, IllegalAccessException {
        Field maxNameLengthField = NameValidator.class.getDeclaredField("MAX_NAME_LENGTH");
        maxNameLengthField.setAccessible(true);
        return (int) maxNameLengthField.get(null);
    }
}
