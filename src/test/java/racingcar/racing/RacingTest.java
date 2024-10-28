package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.Letter.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {
	private Racing racing;
	private OutputStream outputStreamCaptor;
	
	@BeforeEach
	void setUp() {
		// System.out 캡쳐 설정
		outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
		
		String[] nameArr = {"aaa", "bbb", "ccc"};
		racing = Racing.getInstance(nameArr);
	}
	
	@Test
	@DisplayName("지정된 시도 횟수 동안 경주 결과 출력")
	void testPrintResult() {
		long tryingCount = 3;
		racing.printResult(tryingCount);
		
		String output = outputStreamCaptor.toString();
		Arrays.stream(new String[] {"aaa", "bbb", "ccc"})
			.forEach(name -> assertThat(output).contains(name + COLON.toString()));
	}
	
	@Test
	@DisplayName("가장 멀리 이동한 자동차를 우승자로 출력")
	void testPrintWinner() {
		racing.printResult(3);
		racing.printWinner();
		
		String output = outputStreamCaptor.toString();
		assertThat(output).containsAnyOf("aaa", "bbb", "ccc");
	}
}
