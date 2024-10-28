package racingcar;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.GameMessages.*;

public class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void 실행결과_메시지가_출력되는지_확인합니다() {
        // when
        outputView.printResultGuideMessage();

        // then
        String expectedOutput = OUTPUT_RESULT_GUIDE_MESSAGE + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void 자동차별_score가_지정한_문자로_반복돼서_출력되는지_확인합니다() {
        // given
        RacingCar car1 = RacingCar.of("yuze");
        RacingCar car2 = RacingCar.of("woodz");
        car1.addScore();
        car1.addScore();
        car2.addScore();
        List<RacingCar> racingCars = Arrays.asList(car1, car2);

        // when
        outputView.resultMessageLoop(racingCars);

        // then
        String expectedOutput = "yuze : " + OUTPUT_SCORE_CHARACTER.repeat(2) + System.lineSeparator()
                + "woodz : " + OUTPUT_SCORE_CHARACTER.repeat(1) + System.lineSeparator()
                + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void 승자가_올바른_형태로_출력되는지_확인합니다() {
        // given
        List<String> winners = Arrays.asList("yuze", "woodz");

        // when
        outputView.printWinnerMessage(winners);

        // then
        String expectedOutput = OUTPUT_WINNER_GUIDE_MESSAGE + "yuze, woodz";
        assertEquals(expectedOutput, outputStream.toString());
    }
}