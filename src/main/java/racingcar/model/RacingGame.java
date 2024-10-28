package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RaceRound raceRound;
    private final List<Cars> eachRoundResult;

    public RacingGame(Cars cars, RaceRound raceRound){
        this.cars = cars;
        this.raceRound = raceRound;
        eachRoundResult = new ArrayList<>();
    }

    public List<Cars> gameRoundStart() {
        for(int i = 0; i< raceRound.getRounds(); i++){
            RaceRound thisRound = new RaceRound(i, cars);
            thisRound.roundStart(thisRound.getThisRoundCars());

            thisRound.saveRoundResult(new Cars(thisRound.getThisRoundCars()));

            eachRoundResult.add(new Cars(thisRound.getThisRoundCars()));
        }
        return eachRoundResult;
    }

    public Cars getFinalRoundCarsStatus(){
        return eachRoundResult.getLast();
    }
}
