package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.Console;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

class RacingCarMachineTest {

	private ByteArrayOutputStream outputStream;
	private final PrintStream originalOut = System.out;
	private final InputStream originalIn = System.in;
	private OutputHandler outputHandler;
	private InputHandler inputHandler;

	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		outputHandler = new OutputHandler();
		inputHandler = new InputHandler();
	}

	@AfterEach
	void setOriginInputOutput() {
		System.setOut(originalOut);
		System.setIn(originalIn);
		Console.close();
	}

	private RacingCarMachine createRacingCarMachine(String input) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		return new RacingCarMachine(outputHandler, inputHandler);
	}

	@DisplayName("게임을 정상적으로 실행할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"name,poni\n2\n", "name,poni,juni\n3\n", "java\n1\n"})
	void runGameTest(String input) {
		// given
		RacingCarMachine machine = createRacingCarMachine(input);
		String output;

		// when
		machine.run();
		// then
		output = outputStream.toString();
		assertThat(output.contains("최종 우승자 : ")).isTrue();
	}

	@DisplayName("이름을 입력하지 않으면 예외가 발생한다.")
	@Test
	void emptyNameTest() {
		// given
		String input = "\n1\n";
		RacingCarMachine machine = createRacingCarMachine(input);

		// when
		Throwable thrown = catchThrowable(() -> machine.run());

		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름을 입력해 주세요.");
	}

	@DisplayName("5자 이상의 이름이 입력된 경우 예외가 발생한다.")
	@Test
	void tooLongNameTest() {
		// given
		String input = "tooLongName\n1\n";
		RacingCarMachine machine = createRacingCarMachine(input);

		// when
		Throwable thrown = catchThrowable(() -> machine.run());

		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("5자 미만의 이름을 입력해 주세요.");
	}

	@DisplayName("시도 횟수로 음수가 입력되면 예외가 발생한다.")
	@Test
	void negativeNumberTest() {
		// given
		String input = "name\n-1\n";
		RacingCarMachine machine = createRacingCarMachine(input);

		// when
		Throwable thrown = catchThrowable(() -> machine.run());

		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 양수를 입력해주세요.");
	}

	@DisplayName("시도 횟수로 숫자가 아닌 값을 입력하면 예외가 발생한다.")
	@Test
	void notNumberTest() {
		// given
		String input = "name\na\n";
		RacingCarMachine machine = createRacingCarMachine(input);

		// when
		Throwable thrown = catchThrowable(() -> machine.run());

		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 문자를 입력할 수 없습니다.");
	}

	@DisplayName("시도 횟수로 0을 입력하면 예외가 발생한다.")
	@Test
	void zeroTryNumberTest() {
		// given
		String input = "name\n0\n";
		RacingCarMachine machine = createRacingCarMachine(input);

		// when
		Throwable thrown = catchThrowable(() -> machine.run());

		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("게임을 실행할 수 없습니다.");
	}
}