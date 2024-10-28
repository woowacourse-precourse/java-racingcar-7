package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;

public abstract class InputTest {

    @BeforeEach
    protected void init() {
        Console.close();
    }

    protected void presetInput(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
