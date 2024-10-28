package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.Letter.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {
	private Controller controller;
	private OutputStream outputStreamCaptor;
	
	@BeforeEach
	void setUp() {
		// System.out 캡쳐 설정
		outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
		
		controller = Controller.getInstance();
	}
	
	@Test
	void testRun() {
		// 입력값을 System.in으로 설정
		String input = "aaa,bbb,ccc\n3\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		controller.run();
		
		String output = outputStreamCaptor.toString();
		assertThat(output)
			.contains(REQ_RACING_CAR_NAMES.toString(), REQ_TRYING_COUNT.toString())
			.containsAnyOf("aaa", "bbb", "ccc");
		
		String[] nameArr = {"aaa", "bbb", "ccc"};
		IntStream.range(0, nameArr.length)
			.mapToLong(i -> output.lines().filter(line -> line.contains(nameArr[i])).count())
			.forEach(count -> assertThat(count).isGreaterThanOrEqualTo(3));
	}
}
