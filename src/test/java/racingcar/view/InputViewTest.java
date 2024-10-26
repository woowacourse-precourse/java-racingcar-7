package racingcar.view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    private final InputStream originalSystemIn = System.in;

    @AfterEach
    void setSystemin() {
        System.setIn(originalSystemIn);
    }

    @Test
    @DisplayName("자동차 이름목록을 테스트한다")
    void test() {
        //given
        String input = "pobi,woni,jun\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        List<String> carNames = inputView.readCarNames();

        //then
        assertThat(carNames).hasSize(3)
                .containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름의 길이가 6글자가 넘으면 예외가 발생한다")
    void checkLengthWithinLimits() {
        //given
        String input = "pobiiii,woni,jun\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when //then
        assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이는 최대 5글자입니다");
    }
    
    @Test
    @DisplayName("중복되는 자동차 이름이 있으며 예외가 발생한다")
    void hasDuplicatedCarName() {
        //given
        String input = "pobi,pobi,jun\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when //then
        assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 자동차 이름이 있습니다");
    }

    @Test
    @DisplayName("자동차 이름으로 공백이 있으면 예외가 발생한다")
    void hasValidDelimiter() {
        //given
        String input = "pobi,,jun";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when //then
        assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름으로 공백이 허용되지 않습니다");
    }
}