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
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과\n";

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
    void 우승자_한명_결과_출력테스트() {
        String expected = EXECUTION_RESULT_MESSAGE +
                createCarPosition("pobi", "") +
                createCarPosition("woni", MOVE_MARK) +
                createWinnerMessage("woni");

        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new NumberGeneratorTest(List.of(3, 4)));
        Cars oneMovedCars = cars.moveForward();
        gameResult.saveRound(oneMovedCars);
        gameResult.saveWinner(oneMovedCars);

        OutputView.printResult(gameResult.getRoundResults());
        OutputView.printWinner(gameResult.getWinners());

        assertEquals(
                expected.replaceAll("\\s+", ""),
                outputStreamCaptor.toString().replaceAll("\\s+", "")
        );
    }

    @Test
    void 우승자_여러명_결과_출력테스트() {
        String expected = EXECUTION_RESULT_MESSAGE +
                createCarPosition("pobi", MOVE_MARK) +
                createCarPosition("woni", MOVE_MARK) +
                "\n" +
                createWinnerMessage("pobi, woni");

        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new NumberGeneratorTest(List.of(4, 4)));
        Cars oneMovedCars = cars.moveForward();
        gameResult.saveRound(oneMovedCars);
        gameResult.saveWinner(oneMovedCars);

        OutputView.printResult(gameResult.getRoundResults());
        OutputView.printWinner(gameResult.getWinners());

        assertEquals(
                expected.replaceAll("\\s+", ""),
                outputStreamCaptor.toString().replaceAll("\\s+", "")
        );
    }

    @Test
    void 여러_라운드결과_출력테스트() {
        String expected = EXECUTION_RESULT_MESSAGE +
                createCarPosition("pobi", "") +
                createCarPosition("woni", MOVE_MARK) +
                "\n" +
                createCarPosition("pobi", MOVE_MARK) +
                createCarPosition("woni", MOVE_MARK + MOVE_MARK) +
                "\n" +
                createWinnerMessage("woni");

        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new NumberGeneratorTest(List.of(3, 4, 4, 4)));
        Cars oneMovedCars = cars.moveForward();
        gameResult.saveRound(oneMovedCars);
        Cars twoMovedCars = oneMovedCars.moveForward();
        gameResult.saveRound(twoMovedCars);
        gameResult.saveWinner(twoMovedCars);

        OutputView.printResult(gameResult.getRoundResults());
        OutputView.printWinner(gameResult.getWinners());

        assertEquals(
                expected.replaceAll("\\s+", ""),
                outputStreamCaptor.toString().replaceAll("\\s+", "")
        );
    }

    private String createCarPosition(String name, String position) {
        return name + " : " + position + "\n";
    }

    private String createWinnerMessage(String winners) {
        return "최종 우승자 : " + winners + "\n";
    }
}
