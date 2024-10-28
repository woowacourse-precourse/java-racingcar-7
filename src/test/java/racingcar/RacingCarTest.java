package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {
    private RacingCar racingCar;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        racingCar = new RacingCar();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        Console.close();
    }

    @Test
    void 실행_결과_출력_테스트() {
        String input = "pobi,woni\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        racingCar.run();

        String output = outContent.toString();
        assertTrue(output.contains("pobi : "));
        assertTrue(output.contains("woni : "));
    }

    @Test
    void 우승자_출력_테스트() {
        String input = "pobi,woni\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        racingCar.run();

        String output = outContent.toString();
        assertTrue(output.contains("최종 우승자 : "));
    }

    @Test
    public void 글자수가_5보다_클_때_예외테스트() {
        String input = "pobi,woni,jackson\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

    @Test
    public void 시도할_횟수가_숫자가_아닐_때_예외테스트() {
        String input = "pobi,woni,jun\naaa\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

    @Test
    public void 차_이름이_중복됐을_때_예외테스트() {
        String input = "pobi,pobi\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

    @Test
    public void 차_이름이_공백일_때_예외테스트() {
        String input = ",pobi\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

}
