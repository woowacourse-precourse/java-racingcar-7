package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

    @DisplayName("올바른 문자열이 들어갔을 때, 정상 작동한다.")
    @Test
    void Given_CorrectInput_When_NamesHasInput_Then_Success() {
        // Given
        String input = "a,bb,ccc,dddd,eeeee";
        // When
        Names names = new Names(input);

        // Then
        assertThat(names.toString()).isEqualTo(input);
    }

    @DisplayName("올바른 문자열과 문자 앞뒤 공백이 들어갔을 때, 정상 작동한다.")
    @Test
    void Given_CorrectInputWithBlank_When_NamesHasInput_Then_Success() {
        // Given
        String input = "a, bb , ccc , dddd , eeeee";

        // When
        Names names = new Names(input);

        // Then
        assertThat(names).isEqualTo(input);
    }

    @DisplayName("입력값이 하나만 존재할 경우, 에러 메세지를 출력한다.")
    @Test
    void Given_SingleInput_Then_ErrorMessage() {
        // Given
        String input = "aaa";
        // When
        // Then
        assertThatThrownBy(() -> new Names(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("하나의 이름만 들어갈 수는 없습니다.");
    }

    @DisplayName("입력값이 하나과 쉼표가 존재할 경우, 에러 메세지를 출력한다.")
    @Test
    void Given_SingleInputWithComma_Then_ErrorMessage() {
        // Given
        String input = "aaa,";
        // When
        // Then
        assertThatThrownBy(() -> new Names(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("하나의 이름만 들어갈 수는 없습니다.");
    }


    @DisplayName("입력값된 값 사이의 쉼표(,)가 하나보다 많을 경우, 에러가 발생한다.")
    @Test
    void Given_ConsecutiveCommasInput_Then_ErrorMessage() {
        // Given
        String input = "a,,ccc";
        // When
        // Then
        assertThatThrownBy(() -> new Names(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속된 쉼표(,)는 입력될 수 없습니다.");
    }

    @DisplayName("똑같은 이름이 중복되어 입력되었을 때, 에러가 발생한다.")
    @Test
    void Given_DuplicatedNamesInput_Then_ErrorMessage() {
        // Given
        String input = "a,bb,a,ccc";
        // When
        // Then
        assertThatThrownBy(() -> new Names(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 중복될 수 없습니다.");
    }

}