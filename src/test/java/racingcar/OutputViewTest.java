package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Cars;
import racingcar.model.domain.GameResult;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private static final String MOVE_MARK = "-";
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행결과\n";

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 우승자가_한_명일_때_출력() {
        String expected = EXECUTION_RESULT_MESSAGE +
                createCarPosition("pobi", "") +
                createCarPosition("woni", MOVE_MARK) +
                "\n" +
                createWinnerMessage("woni");

        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new TestNumberGenerator(List.of(3, 4)));
        Cars oneMovedCars = cars.moveForward();
        gameResult.recordRound(oneMovedCars);
        gameResult.recordWinner(oneMovedCars);

        OutputView.printResult(gameResult);

        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    void 우승자가_여러명일_때_출력() {
        String expected = EXECUTION_RESULT_MESSAGE +
                createCarPosition("pobi", MOVE_MARK) +
                createCarPosition("woni", MOVE_MARK) +
                "\n" +
                createWinnerMessage("pobi, woni");

        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new TestNumberGenerator(List.of(4, 4)));
        Cars oneMovedCars = cars.moveForward();
        gameResult.recordRound(oneMovedCars);
        gameResult.recordWinner(oneMovedCars);

        OutputView.printResult(gameResult);

        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    void 여러_라운드_결과_출력() {
        String expected = EXECUTION_RESULT_MESSAGE +
                createCarPosition("pobi", "") +
                createCarPosition("woni", MOVE_MARK) +
                "\n" +
                createCarPosition("pobi", MOVE_MARK) +
                createCarPosition("woni", MOVE_MARK + MOVE_MARK) +
                "\n" +
                createWinnerMessage("woni");

        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new TestNumberGenerator(List.of(3, 4, 4, 4)));
        Cars oneMovedCars = cars.moveForward();
        gameResult.recordRound(oneMovedCars);
        Cars twoMovedCars = oneMovedCars.moveForward();
        gameResult.recordRound(twoMovedCars);
        gameResult.recordWinner(twoMovedCars);

        OutputView.printResult(gameResult);

        assertEquals(expected, outputStreamCaptor.toString());
    }

    private String createCarPosition(String name, String position) {
        return name + " : " + position + "\n";
    }

    private String createWinnerMessage(String winners) {
        return "최종 우승자 : " + winners + "\n";
    }
}