package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class RequestTest {

    @Test
    void 자동차_이름_입력() {
        String input = "a,b,c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(Request.inputCar()).isEqualTo("a,b,c");
    }

    @Test
    void 횟수_입력() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(Request.inputTryCount()).isEqualTo("5");
    }
}