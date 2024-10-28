package racingcar.model;

import racingcar.enums.CarState;

public class CarRoundResult {
    private String carName;
    private CarState carState;
    private Integer randomNumber;
    private Integer currentMoveCount;

    public CarRoundResult(String carName,
                          CarState carState,
                          Integer randomNumber,
                          Integer currentMoveCount){
        this.carName = carName;
        this.carState = carState;
        this.randomNumber = randomNumber;
        this.currentMoveCount = currentMoveCount;
    }

    public String getCarName(){
        return carName;
    }

    public Integer getCurrentMoveCount(){
        return currentMoveCount;
    }
}
