package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import view.ViewScreen;

public class ViewScreenTest {
    private final ViewScreen viewScreen = new ViewScreen();

    @Test
    void 입력_정상_작동() {
        String input = "pobi,woni,jun\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(Arrays.asList("pobi,woni,jun", "5"), viewScreen.getInput());
    }
}
