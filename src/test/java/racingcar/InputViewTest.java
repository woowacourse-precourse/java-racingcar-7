package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 입력을 정상적으로 반환한다")
    void readCarNames() {
        String input = "pobi,woni,jun\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = InputView.readCarNames();
        assertThat(result).isEqualTo("pobi,woni,jun");
    }

    @Test
    @DisplayName("시도 횟수 입력을 정상적으로 반환한다")
    void readAttempts() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = InputView.readAttempts();
        assertThat(result).isEqualTo("5");
    }
}
