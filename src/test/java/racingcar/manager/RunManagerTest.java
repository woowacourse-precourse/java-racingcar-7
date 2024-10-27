package racingcar.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RunManagerTest {

    @DisplayName("우승자가 한명인 리스트가 주어지면 이름을 출력한다.")
    @Test
    void printSingleWinner() {
        // given
        RunManager rm = new RunManager(null, null, null);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        List<String> winnerList = List.of("pobi");
        String expectedOutput = "최종 우승자 : pobi";

        // when
        System.setOut(new PrintStream(outputStreamCaptor));
        rm.printResultMessage(winnerList);

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }

    @DisplayName("우승자가 여러명인 리스트가 주어지면 콤마로 구분하여 이름을 출력한다.")
    @Test
    void printMultipleWinners() {
        // given
        RunManager rm = new RunManager(null, null, null);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        List<String> winnerList = List.of("pobi", "crong");
        String expectedOutput = "최종 우승자 : pobi, crong";

        // when
        System.setOut(new PrintStream(outputStreamCaptor));
        rm.printResultMessage(winnerList);

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }
}
