package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Nested
    @DisplayName("Name 객체를 생성할 떄")
    class whenCreateName {

        @Test
        @DisplayName("5글자 이하의 이름이 들어오면 성공적으로 생성한다.")
        void successfullyCreateName() {
            //given
            String invalidName = "song";
            String expected = "song";

            //when then
            Name name = assertDoesNotThrow(() -> new Name(invalidName));
            assertThat(name.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("5글자 이상의 이름이 들어오면 예외를 발생시킨다.")
        void throwsExceptionWhenCreateNameLongerThanFive() {
            //given
            String invalidName = "SongGwanSeok";

            //when then
            assertThatThrownBy(() -> new Name(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 5자를 초과할 수 없습니다.");
        }
    }
}
