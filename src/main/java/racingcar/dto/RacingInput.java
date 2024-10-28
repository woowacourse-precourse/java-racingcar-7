package racingcar.dto;

import java.util.List;

public class RacingInput {
    private List<String> carNames;
    private int tryCount;

    public RacingInput(List<String> InputCars, int tryCount) {
        this.carNames =InputCars;
        this.tryCount = tryCount;
    }

    public List<String>  getCarNames() {
        return this.carNames;
    }

    public int getTryCount(){
        return this.tryCount;
    }
}
