package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTest {
    @Test
    void 경주_정상_수행_출력_성공() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Racing racing = new Racing("car1,car2,car3", "10");
        racing.runRace();

        String[] lines = outContent.toString().split("\n");

        for (int i = 0; i < lines.length; i++) {
            if ((i + 1) % 4 != 0) {
                assertThat(lines[i]).contains("car" + (i + 1) % 4 + " : ");
            } else {
                assertThat(lines[i]).isEqualTo("\n");
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0 / 2 / 0 / car2",
            "1 / 1 / 0 / car1, car2"
    }, delimiter = '/')
    void 승자_목록_문자열_생성_성공(int move1, int move2, int move3, String expected) {
        Racing racing = new Racing("car1,car2,car3", "10");

        for (int i = 0; i < move1; i++) {
            racing.cars.get(0).move();
        }
        for (int i = 0; i < move2; i++) {
            racing.cars.get(1).move();
        }
        for (int i = 0; i < move3; i++) {
            racing.cars.get(2).move();
        }

        String winnerList = racing.createWinnerList();

        assertThat(winnerList).isEqualTo(expected);
    }
}