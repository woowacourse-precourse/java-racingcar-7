package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

public class OutputViewTest {
    private final static String NAME = "gina";

    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @Test
    public void 경주_메시지_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printRaceMessage(new ArrayList<>());

        assertThat(outputStream.toString().trim()).contains(Constants.OUTPUT_RESULT_MESSAGE);
    }

    @Test
    public void 우승자_메시지_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printWinnerMessage(NAME);

        assertThat(outputStream.toString().trim()).contains(Constants.OUTPUT_WINNER_MESSAGE);
    }
}
