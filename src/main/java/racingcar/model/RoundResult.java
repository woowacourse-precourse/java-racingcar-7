package racingcar.model;

import java.util.List;

public class RoundResult {
    private Integer round;
    private List<CarRoundResult> carRoundResults;
    private Integer maxMoveCount;

    public RoundResult(Integer round,
                       List<CarRoundResult> carRoundResults,
                       Integer maxMoveCount){
        this.round = round;
        this.carRoundResults = carRoundResults;
        this.maxMoveCount = maxMoveCount;
    }

    public Integer getMaxMoveCount(){
        return this.maxMoveCount;
    }

    public List<CarRoundResult> getCarRoundResults(){
        return this.carRoundResults;
    }
}
