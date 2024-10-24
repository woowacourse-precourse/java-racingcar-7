package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("입력된 이름이 올바를 때, 데이터가 들어가는지 확인한다.")
    @Test
    void checkCorrectName() {
        // Given
        String input = "pobi";
        Name name = new Name(input);
        // When
        // Then
        assertThat(name.getName()).isEqualTo(input);
    }

    @DisplayName("입력된 이름의 길이가 5보다 크면, 에러가 발생한다.")
    @Test
    void checkNameLengthOverFive() {
        // Given
        String input = "ffffff";
        // When
        // Then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 이름의 길이는 5보다 클 수 없습니다.");
    }


}