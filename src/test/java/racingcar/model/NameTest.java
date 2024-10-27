package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("이름이 5자 이하인 경우 객체를 생성한다.")
    void createName() {
        // given, when
        Name name = new Name("우테코");

        //then
        Assertions.assertThat(name).isNotNull();
    }

    @Test
    @DisplayName("이름이 5자 이상인 경우 예외를 발생한다.")
    void validateName() {
        Assertions.assertThatThrownBy(() -> new Name("우테코우테코"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("이름이 공백으로만 이루어져 있으면 예외를 발생한다.")
    void validateBlank() {
        Assertions.assertThatThrownBy(() -> new Name("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("이름에 공백이 포홤되어 있으면 이를 삭제한 값을 가진다.")
    void removeBlank() {
        // given
        Name name = new Name("우테코 ");

        // when
        String result = name.getValue();

        // then
        Assertions.assertThat(result).isEqualTo("우테코");
    }
}