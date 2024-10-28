package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessages.CLEAR_NAME;
import static racingcar.message.ErrorMessages.LONG_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidInputException;

class NameTest {

    @Test
    @DisplayName("이름이 정상적으로 생성되는지 테스트")
    void createNameSuccessfully() {
        // given
        String validName = "pobi";

        // when
        Name name = new Name(validName);

        // then
        assertThat(name.toString()).isEqualTo(validName);
    }

    @Test
    @DisplayName("이름이 없을 때(Empty) 예외 발생 테스트")
    void throwExceptionWhenNameIsEmpty() {
        // given
        String emptyName = "";

        // when & then
        assertThatThrownBy(() -> new Name(emptyName))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(CLEAR_NAME);
    }

    @Test
    @DisplayName("이름이 없을 때(Blank) 예외 발생 테스트")
    void throwExceptionWhenNameIsBlank() {
        // given
        String emptyName = " ";

        // when & then
        assertThatThrownBy(() -> new Name(emptyName))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(CLEAR_NAME);
    }

    @Test
    @DisplayName("이름이 없을 때(null) 예외 발생 테스트")
    void throwExceptionWhenNameIsNull() {
        // given
        String nullName = null;

        // when & then
        assertThatThrownBy(() -> new Name(nullName))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(CLEAR_NAME);
    }

    @Test
    @DisplayName("이름이 5자를 초과할 때 예외 발생 테스트")
    void throwExceptionWhenNameExceedsMaxLength() {
        // given
        String longName = "pobiwoni";

        // when & then
        assertThatThrownBy(() -> new Name(longName))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(LONG_NAME);
    }
}
