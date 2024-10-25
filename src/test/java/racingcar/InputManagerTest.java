package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @AfterEach
    void rollback() {
        Console.close();
    }

    @DisplayName("올바른 게임 횟수가 입력되는지 확인한다.(10 이하의 숫자)")
    @Test
    void Given_InputIsRight_When_RoundsGetInput_Then_Success() {
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
    void Given_InputIsUnderInteger_When_RoundsGetInput_Then_Success() {
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

    @DisplayName("공백을 입력했을 경우, 에러 메시지가 발생한다.")
    @Test
    void Given_InputIsBlank_Then_GetErrorMessage() {
        // Given
        String input = " ";
        byte[] bytes = input.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        System.setIn(in);
        // When

        // Then
        assertThatThrownBy(InputManager::getGameRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수가 입력되지 않았습니다.");
    }

    @DisplayName("아무것도 입력하지 않았을 때, 에러 메시지가 발생한다.")
    @Test
    void Given_InputIsNothing_Then_GetErrorMessage() {
        // Given
        String input = "\n";
        byte[] bytes = input.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        System.setIn(in);
        // When
        // Then
        assertThatThrownBy(InputManager::getGameRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수가 입력되지 않았습니다.");
    }

    @DisplayName("게임 횟수가 1보다 작은 수가 들어왔을 때, 에러 메시지가 발생한다.")
    @Test
    void Given_InputIsUnderNumberOne_Then_GetErrorMessage() {
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
    void Given_InputIsOverInteger_Then_GetErrorMessage() {
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

    @DisplayName("숫자가 아닌 입력값만 들어왔을 때, 에러 메시지가 발생한다.")
    @Test
    void Given_InputIsNotNumeric_Then_GetErrorMessage() {
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

    @DisplayName("숫자가 아닌 입력값이 숫자와 같이 들어왔을 때, 에러 메시지가 발생한다.")
    @Test
    void Given_InputIsNumericWithNonNumeric_Then_GetErrorMessage() {
        // Given
        String input = "3a";
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