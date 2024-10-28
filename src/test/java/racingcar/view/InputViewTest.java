package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 자동차_이름을_입력받는_경우() {
        String input = "pobi,woni,java\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String carNames = InputView.getCarNames();
        assertThat(carNames).isEqualTo("pobi,woni,java");
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도할_횟수를_입력받는_경우() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String rounds = InputView.getRounds();
        assertThat(rounds).isEqualTo("5");
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("시도할 횟수는 몇 회인가요?");
    }
}
