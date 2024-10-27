package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("최종 우승자를 출력할 수 있다")
    public void printWinner() {
        Race race = new Race("abc,def", "1");
        OutputView outputView = new OutputView();

        race.getCars().get(0).moveBasedOnPoint(3);
        race.getCars().get(1).moveBasedOnPoint(4);
        race.findMaxPosition();
        race.findWinner();

        outputView.printWinner(race);
        assertEquals("최종 우승자 : def\n", outputMessage.toString());
    }
}
