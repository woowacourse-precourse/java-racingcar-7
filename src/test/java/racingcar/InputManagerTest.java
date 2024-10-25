package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @DisplayName("올바른 게임 횟수가 입력되는지 확인한다.(10 이하의 숫자)")
    @Test
    void checkCorrectGameRound() {
        // Given
        String input = "5";
        byte[] bytes = input.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        System.setIn(in);

        // When
        int rounds = InputManager.getGameRound();

        // Then
        assertThat(rounds).isEqualTo(5);
    }


    @DisplayName("올바른 게임 횟수가 입력되는지 확인한다.(정수 최댓값)")
    @Test
    void checkCorrectGameRoundTwo() {
        // Given
        String input = "2147483647";
        byte[] bytes = input.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        System.setIn(in);

        // When
        int rounds = InputManager.getGameRound();

        // Then
        assertThat(rounds).isEqualTo(2147483647);
    }

    @DisplayName("게임 횟수가 1보다 작은 수가 들어왔을 때, 에러 메시지가 발생한다.")
    @Test
    void checkGameRoundUnderOneTest() {
        // Given
        String input = "0";
        byte[] bytes = input.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        System.setIn(in);

        // When
        // Then
        assertThatThrownBy(InputManager::getGameRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수는 1 이상이어야 합니다.");
    }

    @DisplayName("게임 횟수가 정수 범위일 때, 에러 메시지가 발생한다.")
    @Test
    void checkGameRoundRangeInteger() {
        // Given
        String input = "2147483648";
        byte[] bytes = input.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        System.setIn(in);

        // When
        // Then
        assertThatThrownBy(InputManager::getGameRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수는 정수 범위 안 이어야 합니다.");
    }

    @DisplayName("숫자가 아닌 입력값이 들어왔을 때, 에러 메시지가 발생한다.")
    @Test
    void checkGameRoundRangeIsNotNumeric() {
        // Given
        String input = "가나다라";
        byte[] bytes = input.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        System.setIn(in);

        // When
        // Then
        assertThatThrownBy(InputManager::getGameRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수 입력값이 숫자가 아닙니다.");
    }
}