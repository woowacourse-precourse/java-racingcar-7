package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Game;
import racingcar.model.RacingCar;

class OutputViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private List<RacingCar> players;
    private Game game;
    private OutputView outputView;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        players = List.of(new RacingCar("pobi"), new RacingCar("woni"), new RacingCar("jun"));
        game = new Game(players, "3");
        outputView = new OutputView();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 첫_번째_라운드_출력_테스트() {
        String expectedResult = "\n실행 결과\npobi : -\nwoni : --\njun : ---\n";

        players.get(0).move();

        players.get(1).move();
        players.get(1).move();

        players.get(2).move();
        players.get(2).move();
        players.get(2).move();

        outputView.printRoundResults(game);

        assertEquals(expectedResult,
                outputStreamCaptor.toString().substring(0, outputStreamCaptor.toString().length() - 1));
    }

    @Test
    void 두_번째_라운드_출력_테스트() {
        String expectedResult = "pobi : -\nwoni : --\njun : ---\n";

        game.incrementRound();

        players.get(0).move();

        players.get(1).move();
        players.get(1).move();

        players.get(2).move();
        players.get(2).move();
        players.get(2).move();

        outputView.printRoundResults(game);

        assertEquals(expectedResult,
                outputStreamCaptor.toString().substring(0, outputStreamCaptor.toString().length() - 1));
    }
}