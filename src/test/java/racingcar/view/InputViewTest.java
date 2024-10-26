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

    @Disabled
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

}