package racingcar.model;

import java.util.List;

public class RacingGame {
    private Integer totalRound;
    private List<Car> racingCars;
    private List<RoundResult> roundResults;
    private List<String> winners;

    public RacingGame(Integer totalRound, List<Car> racingCars){
        this.totalRound = totalRound;
        this.racingCars = racingCars;
    }

    public Integer getTotalRound(){
        return totalRound;
    }

    public List<Car> getRacingCars(){
        return racingCars;
    }

    public List<RoundResult> getRoundResults(){
        return roundResults;
    }

    public List<String> getWinners(){
        return winners;
    }

    public void setRoundResults(List<RoundResult> roundResults){
        this.roundResults = roundResults;
    }

    public void setWinners(List<String> winners){
        this.winners = winners;
    }
}
