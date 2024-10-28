package racingcar.service;

import java.util.ArrayList;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingAttemptDTO;
import racingcar.dto.RacingCarNamesDTO;

public class RacingGameService {
    public static void runGame(RacingCarNamesDTO racingCarNamesDTO, RacingAttemptDTO racingAttemptDTO){
        ArrayList<RacingGame> racingGames = new ArrayList<RacingGame>();
        Cars cars = new Cars(racingCarNamesDTO);
        int attempts = racingAttemptDTO.getRacingAttempts();

        for(int i = 0; i < attempts; i++){
            racingGames.add(new RacingGame());
            racingGames.get(i).startGame(cars);
        }
    }
}
