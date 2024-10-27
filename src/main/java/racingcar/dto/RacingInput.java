package racingcar.dto;

public class RacingInput {
    private String carNames;
    private int tryCount;

    public RacingInput(String InputCars, int tryCount) {
        this.carNames =InputCars;
        this.tryCount = tryCount;
    }

    public String getCarNames() {
        return this.carNames;
    }

    public int getTryCount(){
        return this.tryCount;
    }
}
