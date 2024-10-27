package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputStream originalSystemIn;
    private final InputView inputView = new InputView();

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    void cleanup() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    @Test
    void getCarNames_기본_입력값을_확인한다() {
        // given
        setInput("pobi,woni,jun");

        // when
        String result = inputView.getCarNames();

        // then
        assertThat(result).isEqualTo("pobi,woni,jun");
    }

    @Test
    void getCarNames_공백이_포함된_입력값을_처리한다() {
        // given
        setInput(" pobi , woni , jun ");

        // when
        String result = inputView.getCarNames();

        // then
        assertThat(result).isEqualTo("pobi , woni , jun");
    }

    @Test
    void getCarNames_빈_문자열을_처리한다() {
        // given
        setInput("\n");

        // when
        String result = inputView.getCarNames();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void getTotalRace_숫자_입력값을_확인한다() {
        // given
        setInput("5");

        // when
        String result = inputView.getTotalRace();

        // then
        assertThat(result).isEqualTo("5");
    }

    @Test
    void getTotalRace_공백이_포함된_숫자를_처리한다() {
        // given
        setInput(" 5 ");

        // when
        String result = inputView.getTotalRace();

        // then
        assertThat(result).isEqualTo("5");
    }

    @Test
    void getTotalRace_빈_문자열을_처리한다() {
        // given
        setInput("\n");

        // when
        String result = inputView.getTotalRace();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void 연속된_입력을_처리한다() {
        // given
        setInput("pobi,woni\n3");

        // when
        String carNames = inputView.getCarNames();
        String roundCount = inputView.getTotalRace();

        // then
        assertThat(carNames).isEqualTo("pobi,woni");
        assertThat(roundCount).isEqualTo("3");
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
