package racingcar.model;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RaceRound rounds;

    public RacingGame(Cars cars, RaceRound rounds){
        this.cars = cars;
        this.rounds = rounds;
    }

    public void RoundsStart(){
        for(int i = 0; i< rounds.getRounds(); i++){
            //TODO : 게임 진행 내용 구현
        }
    }
}
