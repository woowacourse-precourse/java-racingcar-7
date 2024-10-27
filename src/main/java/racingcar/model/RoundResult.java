package racingcar.model;

import java.util.List;

public class RoundResult {
    private Integer round;
    private List<CarRoundResult> carRoundResults;
    private Integer maxCount;

    public RoundResult(Integer round,
                       List<CarRoundResult> carRoundResults,
                       Integer maxCount){
        this.round = round;
        this.carRoundResults = carRoundResults;
        this.maxCount = maxCount;
    }

    public Integer getMaxCount(){
        return this.maxCount;
    }

    public List<CarRoundResult> getCarRoundResults(){
        return this.carRoundResults;
    }
}
