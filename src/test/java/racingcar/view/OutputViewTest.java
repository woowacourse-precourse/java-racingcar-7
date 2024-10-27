package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

class OutputViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private List<RacingCar> players;
    private RacingGame racingGame;
    private OutputView outputView;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        players = List.of(new RacingCar("pobi"), new RacingCar("woni"), new RacingCar("jun"));
        racingGame = new RacingGame(players, "3");
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

        outputView.printRoundResults(racingGame);

        assertEquals(expectedResult,
                outputStreamCaptor.toString().substring(0, outputStreamCaptor.toString().length() - 1));
    }

    @Test
    void 두_번째_라운드_출력_테스트() {
        String expectedResult = "pobi : -\nwoni : --\njun : ---\n";

        racingGame.incrementRound();

        players.get(0).move();

        players.get(1).move();
        players.get(1).move();

        players.get(2).move();
        players.get(2).move();
        players.get(2).move();

        outputView.printRoundResults(racingGame);

        assertEquals(expectedResult,
                outputStreamCaptor.toString().substring(0, outputStreamCaptor.toString().length() - 1));
    }

    @Test
    void 최종_우승자가_한_명인_경우_테스트() {
        String expectedResult = "최종 우승자 : pobi";

        players.getFirst().move();

        outputView.printFinalWinners(racingGame);

        assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }

    @Test
    void 최종_우승자가_두_명인_경우_테스트() {
        String expectedResult = "최종 우승자 : pobi, jun";

        players.getFirst().move();
        players.getLast().move();

        outputView.printFinalWinners(racingGame);

        assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }
}