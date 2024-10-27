package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RaceRound raceRound;
    private final List<RaceRound> gameResult;

    public RacingGame(Cars cars, RaceRound raceRound){
        this.cars = cars;
        this.raceRound = raceRound;
        gameResult = new ArrayList<>();
    }

    public List<RaceRound> getGameResult() {
        return gameResult;
    }

    public void RoundsStart(){
        for(int i = 0; i< raceRound.getRounds(); i++){
            RaceRound thisRound = new RaceRound(i, cars);
            thisRound.roundStart(cars);
            thisRound.saveRoundResult(cars);
        }
    }
}
