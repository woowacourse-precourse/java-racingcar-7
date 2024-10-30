package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarInputTest {

    RacingCarInput racingCarInput = new RacingCarInput();
    InputStream inputStream;

    @BeforeEach
    void setUp() {

        inputStream = System.in;
    }

    @AfterEach
    void tearDown() {

        System.setIn(inputStream);
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 유효한 이름 입력")
    void inputCarNames() {

        setInputs("pobi,woni,jun\n");

        String[] carNames = racingCarInput.inputCarNames();

        Assertions.assertThat(carNames[0]).isEqualTo("pobi");
        Assertions.assertThat(carNames[1]).isEqualTo("woni");
        Assertions.assertThat(carNames[2]).isEqualTo("jun");
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 유효하지 않은 이름 입력(,,,)")
    void inputCarNamesWithBlank() {

        setInputs(",,,\n");

        Assertions.assertThatThrownBy(racingCarInput::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 유효하지 않은 이름 입력(jabaji1)")
    void inputCarNamesOverLength() {

        setInputs("jabaji1\n");

        Assertions.assertThatThrownBy(racingCarInput::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트 - 유효한 시도 횟수 입력")
    void inputTryCount() {

        setInputs("5\n");

        int tryCount = racingCarInput.inputTryCount();

        Assertions.assertThat(tryCount).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트 - 유효하지 않은 시도 횟수 입력(-1)")
    void inputTryCountWithNegativeNumber() {

        setInputs("-1\n");

        Assertions.assertThatThrownBy(racingCarInput::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양의 정수여야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트 - 유효하지 않은 시도 횟수 입력(문자열)")
    void inputTryCountWithString() {

        setInputs("abc\n");

        Assertions.assertThatThrownBy(racingCarInput::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양의 정수여야 합니다.");
    }

    private void setInputs(String input) {

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}