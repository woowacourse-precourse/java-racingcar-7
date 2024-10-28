package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * class: CustomApplicationTest.
 *
 * @author JBumLee
 * @version 2024/10/28
 */
@DisplayName("Application 클래스 테스트")
class CustomApplicationTest {

    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void applicationTest() {
        String input = "pobi,woni\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatNoException().isThrownBy(
                () -> Application.main(new String[]{})
        );
    }
}