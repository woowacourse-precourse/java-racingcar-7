package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class IOTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        this.standardOut = System.out;
        this.captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.captor));
    }

    @AfterEach
    protected void printResult() {
        Console.close();
        System.setOut(standardOut);
        System.out.println(this.output());
    }

    protected final String output() {
        return this.captor.toString().trim();
    }

    protected void systemInput(String value) {
        byte[] buf = (value + "\n").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
