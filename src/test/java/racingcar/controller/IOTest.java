package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IOTest {
    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        printStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    } // setUp

    @AfterEach
    protected void printResult() {
        System.setOut(printStream);
        System.out.println(getOutput());
    } // printResult

    protected String getOutput() {
        return outputStream.toString();
    } // getOutput
} // class