package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManegerTest {

    @DisplayName("")
    @Test
    void input() {
        // Given

        // When

        // Then
    }

    @DisplayName("입력값이 하나만 존재할 경우, 입력할 차 이름은 하나보다 더 많아야 한다는 에러 메세지를 출력한다.")
    @Test
    void checkInputNamesCount() {
        // Given

        // When

        // Then
    }

    @DisplayName("입력값된 값 사이의 쉼표(,)가 하나보다 많을 경우, 에러가 발생한다.")
    @Test
    void checkDoubleComma() {
        // Given

        // When

        // Then
    }

    @DisplayName("입력된 이름의 길이가 5보다 크면, 에러가 발생한다.")
    @Test
    void checkNameLengthOverFive() {
        // Given

        // When

        // Then
    }

    @DisplayName("똑같은 이름이 중복되어 입력되었을 때, 에러가 발생한다.")
    @Test
    void checkDoubleNames() {
        // Given
        Reader reader = new Reader();

        // When
        reader.appendNames();

        // Then
        assertThatThrownBy(() -> );
    }

}