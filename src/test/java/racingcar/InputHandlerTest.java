package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void 사용자_입력_읽기() {
        String mockInput = "tayo,lani,rogi";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
        var runner = new InputHandler();

        String result = runner.readInput();

        assertThat(result).isEqualTo("tayo,lani,rogi");
    }
}
