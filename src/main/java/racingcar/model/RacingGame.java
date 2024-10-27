package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RaceRound raceRound;
    private final List<RaceRound> eachRoundResult;

    public RacingGame(Cars cars, RaceRound raceRound){
        this.cars = cars;
        this.raceRound = raceRound;
        eachRoundResult = new ArrayList<>();
    }

    public List<RaceRound> getEachRoundResult() {
        return eachRoundResult;
    }

    public void gameRoundStart(){
        for(int i = 0; i< raceRound.getRounds(); i++){
            RaceRound thisRound = new RaceRound(i, cars);
            thisRound.roundStart(cars);
            thisRound.saveRoundResult(cars);
        }
    }

    private RaceRound getFinalRound() {
        return eachRoundResult.getLast();
    }

    public Cars getFinalRoundCarsStatus(){
        return getFinalRound().getThisRoundCars();
    }
}
