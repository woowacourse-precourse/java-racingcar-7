package racingcar.serviceTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.repository.RoundRepository;
import racingcar.service.GameService;
import racingcar.util.DependencyFactory;
import racingcar.view.Output;

public class GameTest {

    private final Output output = new Output();
    private final GameService gameService = new GameService(output);
    private GameRepository gameRepository = GameRepository.getInstance();


    @BeforeAll
    public static void beforeAll() {
        DependencyFactory.initialize();
    }

    @Test
    @DisplayName("게임 실행 테스트")
    public void testGame(){
        //given
        List<String> carNames = List.of("hello", "world", "this", "is", "test");
        Integer roundCount = 5;

        //when
        Integer gameId = gameService.startGame(carNames, roundCount);

        Game game = gameRepository.findByGameId(gameId);

        //then
        assertEquals(roundCount, game.getRoundList().size());

        int compareRoundCount = 1;

        for(Round round : game.getRoundList()){
            assertNotNull(round.getCarList());
            assertEquals(round.getCarList().size(), carNames.size());
            assertEquals(round.getScoreBoard().size(), carNames.size());
            assertEquals(compareRoundCount, round.getThisRound());
            compareRoundCount++;
        }
    }
}