package racingcar.presentation.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        inputView.closeConsole();
    }

    @DisplayName("이름 입력은 공백을 포함하지 않은 한글, 숫자, 알파벳 대소문자, 언더바(_), 쉼표(,)만 입력할 수 있다")
    @ValueSource(strings = {"포bi", "_PobI,워n1"})
    @ParameterizedTest
    void 이름_입력_성공(String input) {
        systemSetIn(input);

        String inputLine = inputView.readCarNames();

        assertThat(inputLine).isEqualTo(input);
    }

    @Test
    void 시도_횟수_입력_성공() {
        systemSetIn("1");

        String inputLine = inputView.readTryCount();

        assertThat(inputLine).isEqualTo("1");
    }

    @DisplayName("Console로 받은 입력이 null, EOF가 없다면 시스템 장애다")
    @Test
    void 입력_시스템_시스템_장애() {
        System.setIn(new ByteArrayInputStream(new byte[0]));

        assertThatCode(() -> inputView.readCarNames())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("시스템 장애로 프로그램을 종료합니다. 다시 실행해 주세요.");
    }

    @DisplayName("입력에 빈 문자열이 올 수 없다")
    @Test
    void 입력_실패_빈_문자열() {
        systemSetIn("\n");

        assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 입력해 주세요.");
    }

    @DisplayName("입력에 공백을 포함해 입력할 수 없다")
    @ValueSource(strings = {" ", "po bi"})
    @ParameterizedTest
    void 입력_실패_공백_포함(String input) {
        systemSetIn(input);

        assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 빼고 입력해주세요.");
    }

    @DisplayName("이름 입력에 한글, 숫자, 알파벳 대소문자, 언더바(_), 쉼표(,)외 문자를 입력할 수 없다")
    @ValueSource(strings = {"pobi!", "po_bi+,won|!"})
    @ParameterizedTest
    void 이름_입력_실패_허용_문자_외(String input) {
        systemSetIn(input);

        assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 한글, 숫자, 알파벳 대소문자, 언더바(_), 쉼표(,)만 입력할 수 있습니다");
    }

    @DisplayName("시도 횟수 입력에 숫자 외 문자를 입력할 수 없다")
    @Test
    void 시도_횟수_입력_실패_숫자_외() {
        systemSetIn("10l");

        assertThatThrownBy(() -> inputView.readTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 입력 가능합니다.");
    }

    private void systemSetIn(final String input) {
        InputStream inputStream = new ByteArrayInputStream(
                String.join(System.lineSeparator(), input)
                        .getBytes()
        );
        System.setIn(inputStream);
    }

}
