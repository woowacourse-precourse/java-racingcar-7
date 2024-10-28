package racingcar.service;

import java.util.ArrayList;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGames;
import racingcar.dto.RacingAttemptDTO;
import racingcar.dto.RacingCarNamesDTO;

public class RacingGameService {
    public static void runGame(RacingCarNamesDTO racingCarNamesDTO, RacingAttemptDTO racingAttemptDTO){
        RacingGames racingGames = new RacingGames();
        Cars cars = new Cars(racingCarNamesDTO);
        int attempts = racingAttemptDTO.getRacingAttempts();

        for(int i = 0; i < attempts; i++){
            RacingGame racingGame = new RacingGame();
            racingGame.startGame(cars);
            racingGames.addRacingGame(racingGame);
        }
    }
}
