package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 입력이 쉼표(,)로 구분된 경우, 이름 리스트로 변환")
    void testGetCarNames() {
        // Given
        String input = "pobi,woni,jun";
        setInputStream(input);

        // When
        List<String> carNames = inputView.getCarNames();

        // Then
        assertThat(carNames)
                .hasSize(3)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("시도 횟수를 숫자로 입력했을 때, 올바르게 반환")
    void testGetRaceCountSuccess() {
        // Given
        String input = "5";
        setInputStream(input);

        // When
        int raceCount = inputView.getRaceCount();

        // Then
        assertThat(raceCount).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2"})
    @DisplayName("시도 횟수를 1 미만의 숫자를 입력했을때 예외처리")
    void testValidateRaceCountException_NotPositiveNumber(String input) {
        // Given
        setInputStream(input);

        // When & Then
        assertThatThrownBy(() -> inputView.validateRaceCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "a"})
    @DisplayName("시도 횟수를 숫자가 아닌 문자나 공백을 입력했을때 예외처리")
    void testValidateRaceCountException_NotNumber(String input) {
        // Given
        setInputStream(input);

        // When & Then
        assertThatThrownBy(() -> inputView.validateRaceCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void setInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
