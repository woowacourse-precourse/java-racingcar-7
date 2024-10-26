package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void printExecutionResultHeader() {
        outputView.printExecutionResultHeader();
        assertThat(output.toString()).isEqualTo("\n실행 결과\n");
    }

    @Test
    void printExecutionStatus() {
        LinkedHashMap<String, String> carStatus = new LinkedHashMap<>();
        carStatus.put("pobi", "--");
        carStatus.put("woni", "-");
        carStatus.put("jun", "--");

        outputView.printExecutionStatus(carStatus);
        assertThat(output.toString()).isEqualTo(
                "pobi : --\n"
                        + "woni : -\n"
                        + "jun : --\n\n");
    }

    @Test
    void printFinalWinner() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("jun");

        outputView.printFinalWinner(winners);
        assertThat(output.toString()).isEqualTo("최종 우승자 : pobi, jun\n");
    }
}