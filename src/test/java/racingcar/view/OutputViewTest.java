package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    void init() {
        outputView = new OutputView();
    }

    @Test
    void 단독_우승자_안내_문구_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> winnerList = Arrays.asList(new String[]{"pobi"});

        outputView.printWinnerMessage(winnerList);

        assertThat(outputStream.toString().trim())
                .isEqualTo("최종 우승자 : pobi");
    }
}
