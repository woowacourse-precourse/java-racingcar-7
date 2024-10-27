package racingcar.model;

import racingcar.enums.CarState;

public class CarRoundResult {
    private String carName;
    private CarState carState;
    private Integer randomNumber;
    private Integer currentCount;

    public CarRoundResult(String carName,
                          CarState carState,
                          Integer randomNumber,
                          Integer currentCount){
        this.carName = carName;
        this.carState = carState;
        this.randomNumber = randomNumber;
        this.currentCount = currentCount;
    }

    public String getCarName(){
        return carName;
    }

    public Integer getCurrentCount(){
        return currentCount;
    }
}
