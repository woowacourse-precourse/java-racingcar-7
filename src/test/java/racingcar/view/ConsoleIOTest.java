package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract class ConsoleIOTest {
	private ByteArrayOutputStream outputContent;
	private PrintStream outputStream;

	private Console console;

	@BeforeEach
	void setUp() {
		outputContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputContent));
	}

	@AfterEach
	protected void afterEach() {
		System.setOut(outputStream);
		System.out.println(getOutput());
	}

	protected void setConsoleInput(String input) {
		System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
	}

	protected String getOutput() {
		return outputContent.toString();
	}
}
